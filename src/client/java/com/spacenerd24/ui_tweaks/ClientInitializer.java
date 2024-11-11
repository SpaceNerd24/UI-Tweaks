package com.spacenerd24.ui_tweaks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonWriter;
import com.github.puzzle.core.loader.launch.provider.mod.entrypoint.impls.ClientModInitializer;
import finalforeach.cosmicreach.settings.GameSetting;

public class ClientInitializer implements ClientModInitializer {

    @Override
    public void onInit() {
        Constants.LOGGER.info("UI-Tweaks Initialized");
        Constants.JSON.setOutputType(JsonWriter.OutputType.json);
        Constants.windowHeight = Gdx.graphics.getHeight();
        Constants.windowWidth = Gdx.graphics.getWidth();
    }

}
