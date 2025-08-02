package net.yeoxuhang.endit.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.yeoxuhang.endit.Endit;

@Mod(Endit.MOD_ID)
public class EnditForge {
    public EnditForge() {
        Endit.init();
        MinecraftForge.EVENT_BUS.register(this);
    }
}