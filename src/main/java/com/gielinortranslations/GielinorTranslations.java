package com.gielinortranslations;

import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;

import java.util.*;
import java.util.function.Consumer;

public class GielinorTranslations {
    private final Queue<Runnable> clientThreadQueue = new LinkedList<>();
    public final Map<String, String> state = new HashMap<>();
    public final Map<String, int[]> positionsState = new HashMap<>();

    private final int parentDialogWidgetID;
    private final String configEnabledKey;
    private final String[] originalTexts;
    private boolean waitForGameTick = false;

    private boolean isActive = false;
    private Widget widget;
    private GielinorTranslationsConfig config;

    //******************************** Publics ********************************//

    public GielinorTranslations(int parentDialogWidgetID, String configEnabledKey, String[] originalTexts) {
        this.parentDialogWidgetID = parentDialogWidgetID;
        this.configEnabledKey = configEnabledKey;
        this.originalTexts = originalTexts;
        reset();
    }

    public void setConfig(GielinorTranslationsConfig config) {
        this.config = config;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public void setWaitForGameTick(boolean waitForGameTick) {
        this.waitForGameTick = waitForGameTick;
    }

    public Map<String, Map<GielinorTranslationsConfig.Language, Consumer<GielinorTranslationsWidget>>> getTranslations() {
        return new HashMap<>();
    }

    public void onGameTick(Client client, ConfigManager configManager, GielinorTranslationsConfig config) {
        if (configManager.getConfiguration("gielinortranslations", configEnabledKey).equals("true")) {
            setWidget(client.getWidget(parentDialogWidgetID));
            if(dialogStateChanged()) {
                setConfig(config);
                if(isActive) {
                    refresh();
                } else {
                    reset();
                }
            }
        }

        while (!clientThreadQueue.isEmpty()) {
            Runnable function = clientThreadQueue.poll();
            if (function != null) {
                function.run();
            }
        }
    }

    public void onConfigChanged(GielinorTranslationsConfig config) {
        setConfig(config);
        if(isActive) {
            refresh();
        }
    }

    //******************************** Privates ********************************//

    private void queueOnClientThreadFunction(Runnable f) {
        clientThreadQueue.offer(f);
    }

    private void refresh() {
        translateDialogByWidget(widget);
    }

    private void reset() {
        state.clear();
        for (String originalText : originalTexts) {
            state.put(originalText, originalText);
        }
        positionsState.clear();
        isActive = false;
    }

    private boolean dialogStateChanged() {
        boolean wasActive = isActive;
        isActive = widget != null;
        return wasActive != isActive;
    }

    private void translateDialogByWidget(Widget parentDialog) {
        if (parentDialog == null) {
            return;
        }

        traverseDialog(parentDialog);
    }

    private void traverseDialog(Widget parentDialog) {
        Widget[] staticChildren = parentDialog.getStaticChildren();
        if (staticChildren != null) {
            translateDialog(staticChildren);
        }

        Widget[] dynamicChildren = parentDialog.getDynamicChildren();
        if (dynamicChildren != null) {
            translateDialog(dynamicChildren);
        }
    }

    private void translateDialog(Widget[] widgets) {
        for (Widget widget : widgets) {
            translateIfMatches(widget);
            traverseDialog(widget);
        }
    }

    private void translateIfMatches(Widget widget) {
        for (Map.Entry<String, Map<GielinorTranslationsConfig.Language, Consumer<GielinorTranslationsWidget>>> entry : getTranslations().entrySet()) {
            if (widget.getText().equals(state.get(entry.getKey()))) {
                // Store original position if not already stored
                if (positionsState.get(entry.getKey()) == null) {
                    positionsState.put(entry.getKey(), new int[]{widget.getOriginalX(), widget.getOriginalY()});
                }

                Consumer<GielinorTranslationsWidget> translation = entry.getValue().get(config.language());
                GielinorTranslationsWidget gtw = new GielinorTranslationsWidget(this, widget, config, entry.getKey());
                if(waitForGameTick) {
                    queueOnClientThreadFunction(() -> translation.accept(gtw));
                } else {
                    translation.accept(gtw);
                }
            }
        }
    }
}
