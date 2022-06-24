package net.goldorion.nds.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeathScreen.class)
public class DeathScreenMixin {

    @Inject(method = "init()V", at = @At("HEAD"))
    protected void init(CallbackInfo ci) {
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.requestRespawn();
            MinecraftClient.getInstance().setScreen(null);
        }
    }
}
