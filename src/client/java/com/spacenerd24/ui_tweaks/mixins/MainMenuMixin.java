package com.spacenerd24.ui_tweaks.mixins;

import com.badlogic.gdx.Gdx;
import com.spacenerd24.ui_tweaks.CustomOptionsMenu;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.MainMenu;
import finalforeach.cosmicreach.ui.HorizontalAnchor;
import finalforeach.cosmicreach.ui.UIElement;
import com.spacenerd24.ui_tweaks.Constants;
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

//    @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lfinalforeach/cosmicreach/ui/UIElement;setText(Ljava/lang/String;)V", ordinal = 0))
//    private void setText(UIElement startButton, String text) {
//        String str = String.valueOf(Constants.fulscreen.getValue());
//        startButton.setText(str);
//    }

}
