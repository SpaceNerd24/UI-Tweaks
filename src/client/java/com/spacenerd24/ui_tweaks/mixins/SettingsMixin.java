package com.spacenerd24.ui_tweaks.mixins;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonWriter;
import com.spacenerd24.ui_tweaks.Constants;
import finalforeach.cosmicreach.GameSingletons;
import finalforeach.cosmicreach.gamestates.OptionsMenu;
import finalforeach.cosmicreach.io.SaveLocation;
import finalforeach.cosmicreach.settings.GameSetting;
import finalforeach.cosmicreach.settings.SettingsDictionary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

@Mixin(GameSetting.class)
public class SettingsMixin {
    @Inject(method = "loadSettings", at = @At("TAIL"))
    private static void loadSettings0(CallbackInfo ci) {
        Constants.LOGGER.info("Loading Custom Settings");

        loadCustomSettings();
        Constants.customSettings.put("fullscreen", Constants.fulscreen);
        Constants.customSettings.put("noprealpha", Constants.noPreAlpha);
        Constants.customSettings.put("showpuzzleversion", Constants.showPuzzleVersion);
    }

    @Inject(method = "saveSettings", at = @At("HEAD"))
    private static void saveSettings0(CallbackInfo ci) {
        Constants.LOGGER.info("Saving Custom Settings");

        saveCustomSettings();
    }

    private static void saveCustomSettings() {
        String jsonToSave = Constants.JSON.prettyPrint(Constants.customSettings);
        File settingsFile = new File(SaveLocation.getSaveFolderLocation() + "/" + Constants.SETTINGS_FILE_NAME);

        try {
            FileOutputStream fos = new FileOutputStream(settingsFile);

            try {
                fos.write(jsonToSave.getBytes(StandardCharsets.UTF_8));
            } catch (Throwable var6) {
                try {
                    fos.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            fos.close();
        } catch (Exception var7) {
            Exception ex = var7;
            ex.printStackTrace();
        }
    }

    private static void loadCustomSettings() {
        File settingsFile = new File(SaveLocation.getSaveFolderLocation() + "/" + Constants.SETTINGS_FILE_NAME);
        if (settingsFile.exists()) {
            try {
                FileInputStream fis = new FileInputStream(settingsFile);

                try {
                    Constants.customSettings.read(Constants.JSON, (new JsonReader()).parse(fis));
                } catch (Throwable var5) {
                    try {
                        fis.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }

                    throw var5;
                }

                fis.close();
            } catch (Exception var6) {
                Exception ex = var6;
                ex.printStackTrace();
            }

        }
    }
}
