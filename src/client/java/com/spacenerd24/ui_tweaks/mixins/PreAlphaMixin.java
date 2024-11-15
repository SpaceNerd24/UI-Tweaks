package com.spacenerd24.ui_tweaks.mixins;

import com.spacenerd24.ui_tweaks.Constants;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.MainMenu;
import finalforeach.cosmicreach.gamestates.PrealphaPreamble;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PrealphaPreamble.class)
public class PreAlphaMixin extends GameState {
    @Inject(method = "render", at = @At("HEAD"))
    private void create0(CallbackInfo ci) {
        if (!Constants.noPreAlpha.getValue()) {
            GameState.switchToGameState(new MainMenu());
        }
    }
}
