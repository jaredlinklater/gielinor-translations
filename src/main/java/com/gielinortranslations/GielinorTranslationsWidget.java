package com.gielinortranslations;

import net.runelite.api.widgets.Widget;

public class GielinorTranslationsWidget {
    Widget widget;
    GielinorTranslationsConfig config;
    String originalText;

    public GielinorTranslationsWidget(Widget widget, GielinorTranslationsConfig config, String originalText) {
        this.widget = widget;
        this.config = config;
        this.originalText = originalText;
    }
}
