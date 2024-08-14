package com.gielinortranslations;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Gielinor Translations"
)
public class GielinorTranslationsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private GielinorTranslationsConfig config;

	@Provides
	GielinorTranslationsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GielinorTranslationsConfig.class);
	}

	static final GielinorTranslations[] translationClasses = {
			new PharaohsSceptreTranslations(),
			new GnomeGliderTranslations()
	};

	@Subscribe
	public void onGameTick(GameTick gameTick) {
		for (GielinorTranslations t : translationClasses) {
			if (configManager.getConfiguration("gielinortranslations", t.configEnabledKey).equals("true")) {
				t.setConfig(config);
				t.translateDialogByWidget(client.getWidget(t.parentDialogWidgetID));
			}
		}
	}
}
