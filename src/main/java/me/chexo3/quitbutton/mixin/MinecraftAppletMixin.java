package me.chexo3.quitbutton.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin (MinecraftApplet.class)
public class MinecraftAppletMixin {

    @Shadow private Minecraft minecraft;

    @Inject(method= "init()V", at=@At("TAIL"), remap = false)
    private void enableQuitButton(CallbackInfo ci) {
        minecraft.isApplet = false;
    }
}