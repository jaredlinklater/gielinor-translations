package com.gielinortranslations;

import java.util.Map;
import java.util.function.Consumer;

public class GnomeGliderTranslations extends GielinorTranslations {
    static String[] originalTexts = {"Ta Quir Priw", "Sindarpos", "Lemanto Andra", "Kar-Hewo", "Lemantolly", "Undri", "Ookookolly<br>Undri", "Gandius"};

    public GnomeGliderTranslations() {
        super(9043968, "gnomeGlider", originalTexts);
    }

    public Map<String, Map<GielinorTranslationsConfig.Language, Consumer<GielinorTranslationsWidget>>> getTranslations() {
        return Map.of(
            "Ta Quir Priw", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "Tree Gnome<br>Stronghold");
                    reposition(gtw, -22, -4);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "The Guardian<br>Tree");
                    reposition(gtw, -22, -4);
                }
            ),
            "Sindarpos", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "White Wolf<br>Mountain");
                    reposition(gtw, -14, 0);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "Big Rocks");
                    reposition(gtw, -14, 0);
                }
            ),
            "Lemanto Andra", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "Digsite");
                    reposition(gtw, 30, 0);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "Man City");
                    reposition(gtw, 20, 0);
                }
            ),
            "Kar-Hewo", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "Al-Kharid");;
                    reposition(gtw, 4, 0);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "No Grass");;
                    reposition(gtw, 4, 0);
                }
            ),
            "Lemantolly", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "Feldip Hills");
                    reposition(gtw, 0, -4);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "Stupid Man<br>Lands");
                    reposition(gtw, 24, -4);
                }
            ),
            "Undri", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "");
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "");
                }
            ),
            "Ookookolly<br>Undri", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "Ape Atoll");
                    gtw.widget.setOriginalWidth(70);
                    reposition(gtw, 0, 6);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "Stupid Monkey Lands");
                    gtw.widget.setOriginalWidth(100);
                    reposition(gtw, -30, -4);
                }
            ),
            "Gandius", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    updateText(gtw, "Karamja");
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    updateText(gtw, "Jungle");
                }
            )
        );
    }
}
