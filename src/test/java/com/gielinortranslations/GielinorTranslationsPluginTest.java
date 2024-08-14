package com.gielinortranslations;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GielinorTranslationsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GielinorTranslationsPlugin.class);
		RuneLite.main(args);
	}
}