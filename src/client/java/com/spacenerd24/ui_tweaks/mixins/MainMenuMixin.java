package com.spacenerd24.ui_tweaks.mixins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.github.puzzle.game.common.Puzzle;
import com.spacenerd24.ui_tweaks.CustomOptionsMenu;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.MainMenu;
import finalforeach.cosmicreach.ui.FontRenderer;
import finalforeach.cosmicreach.ui.HorizontalAnchor;
import finalforeach.cosmicreach.ui.UIElement;
import com.spacenerd24.ui_tweaks.Constants;
import finalforeach.cosmicreach.ui.VerticalAnchor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MainMenu.class)
public class MainMenuMixin extends GameState {

    @Inject(method = "create", at = @At("TAIL"))
    private void create0(CallbackInfo ci) {

        UIElement customOptions = new UIElement(-385.0F, -275.0F, 275.0F, 35.0F) {
            public void onClick() {
                super.onClick();
                Constants.LOGGER.info("Switching to Custom Options Menu");
                GameState.switchToGameState(new CustomOptionsMenu());
            }
        };
        customOptions.hAnchor = HorizontalAnchor.CENTERED;
        customOptions.setText("Modded Options");
        customOptions.show();
        this.uiObjects.add(customOptions);
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void render0(CallbackInfo ci) {
        if (Constants.fulscreen.getValue()) {
            Gdx.graphics.setUndecorated(true);
            Gdx.graphics.setWindowedMode(Gdx.graphics.getDisplayMode().width, Gdx.graphics.getDisplayMode().height);
        } else {
            Gdx.graphics.setUndecorated(false);
            Gdx.graphics.setWindowedMode(Constants.windowWidth, Constants.windowHeight);
        }
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void render1(CallbackInfo ci) {
        batch.setProjectionMatrix(this.uiCamera.combined);
        batch.begin();
        Vector2 TextDim = new Vector2();
        float y = -60.0F;
        String customText = "UI-Tweaks Version: " + Constants.version;
        FontRenderer.getTextDimensions(this.uiViewport, customText, TextDim);
        batch.setColor(Color.GRAY);
        FontRenderer.drawText(batch, this.uiViewport, customText, -7.0F, y + 1.0F, HorizontalAnchor.RIGHT_ALIGNED, VerticalAnchor.BOTTOM_ALIGNED);
        batch.setColor(Color.WHITE);
        FontRenderer.drawText(batch, this.uiViewport, customText, -8.0F, y, HorizontalAnchor.RIGHT_ALIGNED, VerticalAnchor.BOTTOM_ALIGNED);
        batch.end();
        if (Constants.showPuzzleVersion.getValue()) {
            batch.setProjectionMatrix(this.uiCamera.combined);
            batch.begin();
            Vector2 TextDim2 = new Vector2();
            float y2 = -80.0F;
            String customText2 = "Puzzle Loader Version: " + com.github.puzzle.core.Constants.getVersion();
            FontRenderer.getTextDimensions(this.uiViewport, customText2, TextDim2);
            batch.setColor(Color.GRAY);
            FontRenderer.drawText(batch, this.uiViewport, customText2, -7.0F, y2 + 1.0F, HorizontalAnchor.RIGHT_ALIGNED, VerticalAnchor.BOTTOM_ALIGNED);
            batch.setColor(Color.WHITE);
            FontRenderer.drawText(batch, this.uiViewport, customText2, -8.0F, y2, HorizontalAnchor.RIGHT_ALIGNED, VerticalAnchor.BOTTOM_ALIGNED);
            batch.end();
        }
    }

//    @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lfinalforeach/cosmicreach/ui/UIElement;setText(Ljava/lang/String;)V", ordinal = 0))
//    private void setText(UIElement startButton, String text) {
//        String str = String.valueOf(Constants.fulscreen.getValue());
//        startButton.setText(str);
//    }

}
