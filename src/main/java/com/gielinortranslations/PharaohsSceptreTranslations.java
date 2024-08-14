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
                GielinorTranslationsConfig.Language.ENGLISH, gtw -> updateTextWithOriginal(gtw, "Pyramid Plunder"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> updateTextWithOriginal(gtw, "Tomb of Kings")
            ),
            "Jaleustrophos.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> updateTextWithOriginal(gtw, "Agility Pyramid"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> updateTextWithOriginal(gtw, "Tomb of the Agile")
            ),
            "Jaldraocht.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> updateTextWithOriginal(gtw, "Ancient Pyramid"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> updateTextWithOriginal(gtw, "Tomb of Magic")
            ),
            "Jaltevas.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> updateTextWithOriginal(gtw, "Necropolis"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> updateTextWithOriginal(gtw, "Tomb of the Father")
            ),
            "Nowhere.", Map.of(
                GielinorTranslationsConfig.Language.ENGLISH,  gtw -> updateTextWithOriginal(gtw, "Nowhere"),
                GielinorTranslationsConfig.Language.ENGLISH_LITERAL, gtw -> updateTextWithOriginal(gtw, "Nowhere")
            )
        );
    }
}
