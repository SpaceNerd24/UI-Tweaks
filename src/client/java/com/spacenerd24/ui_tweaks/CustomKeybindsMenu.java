package com.spacenerd24.ui_tweaks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.MainMenu;
import finalforeach.cosmicreach.lang.Lang;
import finalforeach.cosmicreach.ui.FontRenderer;
import finalforeach.cosmicreach.ui.HorizontalAnchor;
import finalforeach.cosmicreach.ui.UIElement;
import finalforeach.cosmicreach.ui.VerticalAnchor;

// Not actively working need to figure out access widener
public class CustomKeybindsMenu extends GameState {
    public CustomKeybindsMenu() {

        UIElement exitButton = new UIElement(0.0F, 200.0F, 250.0F, 50.0F) {
            public void onClick() {
                super.onClick();
                GameState.switchToGameState(new CustomOptionsMenu());
            }
        };
        exitButton.setText("Return");
        exitButton.show();
        this.uiObjects.add(exitButton);
    }

    public void addKeybind() {

    }

    public void render() {
        super.render();

        ScreenUtils.clear(0, 0, 0, 1.0F, true);
        Gdx.gl.glEnable(2929);
        Gdx.gl.glDepthFunc(513);
        Gdx.gl.glEnable(2884);
        Gdx.gl.glCullFace(1029);
        Gdx.gl.glEnable(3042);
        Gdx.gl.glBlendFunc(770, 771);
        this.drawUIElements();
        batch.setProjectionMatrix(this.uiCamera.combined);
        batch.begin();
        Vector2 TextDim = new Vector2();
        float y = -10.0F;
        String customText = "UI-Tweaks Version: " + Constants.version;
        FontRenderer.getTextDimensions(this.uiViewport, customText, TextDim);
        batch.setColor(Color.GRAY);
        FontRenderer.drawText(batch, this.uiViewport, customText, -7.0F, y + 1.0F, HorizontalAnchor.RIGHT_ALIGNED, VerticalAnchor.BOTTOM_ALIGNED);
        batch.setColor(Color.WHITE);
        FontRenderer.drawText(batch, this.uiViewport, customText, -8.0F, y, HorizontalAnchor.RIGHT_ALIGNED, VerticalAnchor.BOTTOM_ALIGNED);
        batch.end();

    }
}
