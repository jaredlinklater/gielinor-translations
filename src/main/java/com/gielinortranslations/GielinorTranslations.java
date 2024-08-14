package com.gielinortranslations;

import net.runelite.api.widgets.Widget;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GielinorTranslations {
    GielinorTranslationsConfig config;

    int parentDialogWidgetID;
    String configEnabledKey;
    String[] originalTexts;

    Map<String, String> state = new HashMap<>();
    Map<String, int[]> positionsState = new HashMap<>();

    public GielinorTranslations(int parentDialogWidgetID, String configEnabledKey, String[] originalTexts) {
        this.parentDialogWidgetID = parentDialogWidgetID;
        this.configEnabledKey = configEnabledKey;
        this.originalTexts = originalTexts;
        resetDialog();
    }

    private void resetDialog() {
        state.clear();
        for (String originalText : originalTexts) {
            state.put(originalText, originalText);
        }
        positionsState.clear();
    }

    public void setConfig(GielinorTranslationsConfig config) {
        this.config = config;
    }

    public Map<String, Map<GielinorTranslationsConfig.Language, Consumer<GielinorTranslationsWidget>>> getTranslations() {
        return new HashMap<>();
    }

    protected void reposition(GielinorTranslationsWidget gtw, int relX, int relY) {
        Widget widget = gtw.widget;
        int[] pos = positionsState.get(gtw.originalText);
        widget.setOriginalX(pos[0] + relX);
        widget.setOriginalY(pos[1] + relY);
        widget.revalidate();
    }

    private static String constructTranslationWithOriginal(GielinorTranslationsWidget gtw, String translation) {
        if (gtw.config.includeOriginal()) {
            return gtw.originalText + " (" + translation + ")";
        } else {
            return translation;
        }
    }

    protected void updateText(GielinorTranslationsWidget gtw, String newText) {
        if (gtw.originalText.equals(newText)) {
            return;
        }

        state.replace(gtw.originalText, newText);
        gtw.widget.setText(newText);
    }

    protected void updateTextWithOriginal(GielinorTranslationsWidget gtw, String translatedText) {
        updateText(gtw, constructTranslationWithOriginal(gtw, translatedText));
    }

    /////////////////////////////////////////////////////////////////////////////////////

    public void translateDialogByWidget(Widget parentDialog) {
        if (parentDialog == null) {
            resetDialog();
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
                if (positionsState.get(entry.getKey()) == null) {
                    positionsState.put(entry.getKey(), new int[]{widget.getOriginalX(), widget.getOriginalY()});
                }
                entry.getValue().get(config.language()).accept(new GielinorTranslationsWidget(widget, config, entry.getKey()));
            }
        }
    }
}
