package com.gielinortranslations;

import net.runelite.api.widgets.Widget;

public class GielinorTranslationsWidget {
    GielinorTranslations manager;
    Widget widget;
    GielinorTranslationsConfig config;
    String originalText;

    public GielinorTranslationsWidget(GielinorTranslations manager, Widget widget, GielinorTranslationsConfig config, String originalText) {
        this.manager = manager;
        this.widget = widget;
        this.config = config;
        this.originalText = originalText;
    }

    protected void reposition(int relX, int relY) {
        int[] pos = manager.positionsState.get(originalText);
        widget.setOriginalX(pos[0] + relX);
        widget.setOriginalY(pos[1] + relY);
        widget.revalidate();
    }

    private String constructTranslationWithOriginal(String translation) {
        if (config.includeOriginal()) {
            return originalText + " (" + translation + ")";
        } else {
            return translation;
        }
    }

    protected void updateText(String newText) {
        if (originalText.equals(newText)) {
            return;
        }

        manager.state.replace(originalText, newText);
        widget.setText(newText);
    }

    protected void updateTextWithOriginal(String translatedText) {
        updateText(constructTranslationWithOriginal(translatedText));
    }
}
