package net.yeoxuhang.endit;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.yeoxuhang.endit.command.EndSpawnCommand;

@Mod(value=Endit.MOD_ID, dist = Dist.DEDICATED_SERVER)
public class EnditNeoForge {

    public EnditNeoForge() {
        Endit.init();
        NeoForge.EVENT_BUS.register(this);
    }
}
