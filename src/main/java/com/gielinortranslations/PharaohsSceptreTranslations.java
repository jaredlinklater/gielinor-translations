package com.gielinortranslations;

import java.util.Map;
import java.util.function.Consumer;

public class PharaohsSceptreTranslations extends GielinorTranslations {
    public PharaohsSceptreTranslations() {
        super(14352385, "pharaohsSceptre", new String[]{
            "Jalsavrah.",
            "Jaleustrophos.",
            "Jaldraocht.",
            "Jaltevas.",
            "Nowhere."
        });
    }

    public Map<String, Map<GielinorTranslationsConfig.Language, Consumer<GielinorTranslationsWidget>>> getTranslations() {
        return Map.of(
            "Jalsavrah.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> gtw.updateTextWithOriginal("Pyramid Plunder"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> gtw.updateTextWithOriginal("Tomb of Kings")
            ),
            "Jaleustrophos.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> gtw.updateTextWithOriginal("Agility Pyramid"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> gtw.updateTextWithOriginal("Tomb of the Agile")
            ),
            "Jaldraocht.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> gtw.updateTextWithOriginal("Ancient Pyramid"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> gtw.updateTextWithOriginal("Tomb of Magic")
            ),
            "Jaltevas.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> gtw.updateTextWithOriginal("Necropolis"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> gtw.updateTextWithOriginal("Tomb of the Father")
            ),
            "Nowhere.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> gtw.updateTextWithOriginal("Nowhere"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> gtw.updateTextWithOriginal("Nowhere")
            )
        );
    }
}
