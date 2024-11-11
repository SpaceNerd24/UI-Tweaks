package com.spacenerd24.ui_tweaks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import finalforeach.cosmicreach.GameSingletons;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.MainMenu;
import finalforeach.cosmicreach.gamestates.OptionsMenu;
import finalforeach.cosmicreach.lang.Lang;
import finalforeach.cosmicreach.settings.GraphicsSettings;
import finalforeach.cosmicreach.ui.ToggleButton;
import finalforeach.cosmicreach.ui.UIElement;
import org.jline.utils.Display;

public class CustomOptionsMenu extends GameState {
    private final static String fullscreenText = "Fullscreen: ";
    private final static String noPreAlphaScreenText= "Pre Alpha Screen: ";

    public CustomOptionsMenu() {
        final GameState thisState = this;
        UIElement fullscreenButton = new ToggleButton(fullscreenText, Constants.fulscreen, 0.0f, -200.0F, 250.0F, 50.0F) {
            public void updateValue() {
                Constants.fulscreen.setValue(this.getValue());
            }
        };
        fullscreenButton.show();
        this.uiObjects.add(fullscreenButton);
        UIElement noPreAlphaScreen = new ToggleButton(noPreAlphaScreenText, Constants.noPreAlpha, 0.0f, -140.0F, 250.0F, 50.0F) {
            public void updateValue() {
                Constants.noPreAlpha.setValue(this.getValue());
            }
        };
        noPreAlphaScreen.show();
        this.uiObjects.add(noPreAlphaScreen);
        UIElement exitButton = new UIElement(0.0F, 200.0F, 250.0F, 50.0F) {
            public void onClick() {
                super.onClick();
                GameState.switchToGameState(new MainMenu());
            }
        };
        exitButton.setText(Lang.get("doneButton"));
        exitButton.show();
        this.uiObjects.add(exitButton);
    }

    public void render() {
        super.render();

        ScreenUtils.clear(0.145F, 0.078F, 0.153F, 1.0F, true);
        Gdx.gl.glEnable(2929);
        Gdx.gl.glDepthFunc(513);
        Gdx.gl.glEnable(2884);
        Gdx.gl.glCullFace(1029);
        Gdx.gl.glEnable(3042);
        Gdx.gl.glBlendFunc(770, 771);
        this.drawUIElements();
        if (Constants.fulscreen.getValue()) {
            Gdx.graphics.setUndecorated(true);
            Gdx.graphics.setWindowedMode(Gdx.graphics.getDisplayMode().width, Gdx.graphics.getDisplayMode().height);
        } else {
            Gdx.graphics.setUndecorated(false);
            Gdx.graphics.setWindowedMode(Constants.windowWidth, Constants.windowHeight);
        }
    }
}
