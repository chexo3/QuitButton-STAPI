package me.chexo3.quitbutton.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.menu.MainMenu;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin (MainMenu.class)
public class MainMenuMixin {

    //Refactored to use a redirected field access Mixin instead. Should be less side effects.
    @Redirect(method = "init", at=@At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;isApplet:Z", opcode = Opcodes.GETFIELD))
    private boolean enableQuitButton(Minecraft minecraft) { return false; }

}