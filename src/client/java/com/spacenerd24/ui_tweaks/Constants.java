package com.spacenerd24.ui_tweaks;

import com.badlogic.gdx.utils.Json;
import finalforeach.cosmicreach.settings.BooleanSetting;
import finalforeach.cosmicreach.settings.SettingsDictionary;
import finalforeach.cosmicreach.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constants {

    public static final String MOD_ID = "ui-tweaks";
    public static final Identifier MOD_NAME = Identifier.of(MOD_ID, "UI Tweaks");
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static SettingsDictionary customSettings = new SettingsDictionary();
    public static final String SETTINGS_FILE_NAME = "customGameSettings.json";
    public static final Json JSON = new Json();
    public static final String version = "v1.1.0";

    public static BooleanSetting fulscreen = new BooleanSetting("fullscreen", false);;
    public static BooleanSetting showPuzzleVersion = new BooleanSetting("showpuzzleversion", true);;
    public static BooleanSetting noPreAlpha = new BooleanSetting("noprealpha", true);;

    public static int windowWidth = 0;
    public static int windowHeight =  0;
}
