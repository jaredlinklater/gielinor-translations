package com.gielinortranslations;

import java.util.Map;
import java.util.function.Consumer;

public class GnomeGliderTranslations extends GielinorTranslations {
    public GnomeGliderTranslations() {
        super(9043968, "gnomeGlider", new String[]{
            "Ta Quir Priw",
            "Sindarpos",
            "Lemanto Andra",
            "Kar-Hewo",
            "Lemantolly",
            "Undri",
            "Ookookolly<br>Undri",
            "Gandius"
        });
        setWaitForGameTick(true);
    }

    public Map<String, Map<GielinorTranslationsConfig.Language, Consumer<GielinorTranslationsWidget>>> getTranslations() {
        return Map.of(
            "Ta Quir Priw", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("Tree Gnome<br>Stronghold");
                    gtw.reposition(-22, -4);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("The Guardian<br>Tree");
                    gtw.reposition(-22, -4);
                }
            ),
            "Sindarpos", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("White Wolf<br>Mountain");
                    gtw.reposition(-14, 0);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("Big Rocks");
                    gtw.reposition(-14, 0);
                }
            ),
            "Lemanto Andra", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("Digsite");
                    gtw.reposition(30, 0);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("Man City");
                    gtw.reposition(20, 0);
                }
            ),
            "Kar-Hewo", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("Al-Kharid");;
                    gtw.reposition(4, 0);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("No Grass");;
                    gtw.reposition(4, 0);
                }
            ),
            "Lemantolly", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("Feldip Hills");
                    gtw.reposition(0, -4);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("Stupid Man<br>Lands");
                    gtw.reposition(24, -4);
                }
            ),
            "Undri", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("");
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("");
                }
            ),
            "Ookookolly<br>Undri", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("Ape Atoll");
                    gtw.widget.setOriginalWidth(70);
                    gtw.reposition(0, 6);
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("Stupid Monkey Lands");
                    gtw.widget.setOriginalWidth(100);
                    gtw.reposition(-30, -4);
                }
            ),
            "Gandius", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> {
                    gtw.updateText("Karamja");
                },
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> {
                    gtw.updateText("Jungle");
                }
            )
        );
    }
}
