package org.k4n3d4.FovLimiter.mixins;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import org.k4n3d4.FovLimiter.FovLimiterModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Shadow private float fovModifier;

    @Inject(method = "tickFov", at = @At("TAIL"))
    private void clampFovModifier(CallbackInfo ci) {
        if (!FovLimiterModule.IsEnable) {
            return;
        }

        float min = FovLimiterModule.minFov.getValue().floatValue();
        float max = FovLimiterModule.maxFov.getValue().floatValue();
        this.fovModifier = Mth.clamp(this.fovModifier, min, max);
    }
}
