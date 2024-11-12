package com.spacenerd24.ui_tweaks.mixins;

import finalforeach.cosmicreach.entities.player.Player;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.InGame;
import finalforeach.cosmicreach.gamestates.LoadingGame;
import finalforeach.cosmicreach.gamestates.MainMenu;
import finalforeach.cosmicreach.ui.HorizontalAnchor;
import finalforeach.cosmicreach.ui.UIElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LoadingGame.class)
public class LoadingScreenMixin extends GameState {
    @Inject(method = "create", at = @At("TAIL"))
    private void create0(CallbackInfo ci) {
        UIElement customOptions = new UIElement(-0.0f, -100.0f, 275.0F, 35.0F) {
            public void onClick() {
                super.onClick();
                GameState.switchToGameState(new MainMenu());
            }
        };
        customOptions.hAnchor = HorizontalAnchor.CENTERED;
        customOptions.setText("Cancel");
        customOptions.show();
        this.uiObjects.add(customOptions);
    }
}
