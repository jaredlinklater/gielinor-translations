package com.gielinortranslations;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("gielinortranslations")
public interface GielinorTranslationsConfig extends Config {

	enum Language {
		ENGLISH,
		ENGLISH_LITERAL;
	}

	@ConfigItem(
			position = 0,
			keyName = "language",
			name = "Language",
			description = "Language to translate dialogs to"
	)
	default Language language()
	{
		return Language.ENGLISH;
	}

	@ConfigItem(
			position = 1,
			keyName = "includeOriginal",
			name = "Include Original",
			description = "Include the original text (where possible)"
	)
	default boolean includeOriginal()
	{
		return true;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@ConfigSection(
			name = "Translatable Dialogs",
			description = "Toggle which dialogs should be translated",
			position = 99
	)
	String dialogSection = "dialogs";

	@ConfigItem(
			position = 0,
			keyName = "gnomeGlider",
			name = "Gnome Glider",
			description = "Enables translation of Gnome Glider destinations",
			section = dialogSection
	)
	default boolean gnomeGlider()
	{
		return true;
	}

	@ConfigItem(
			position = 1,
			keyName = "pharaohsSceptre",
			name = "Pharaoh's Sceptre",
			description = "Enables translation of Pharaoh's Sceptre teleport locations",
			section = dialogSection
	)
	default boolean pharaohsSceptre()
	{
		return true;
	}
}
