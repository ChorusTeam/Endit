package net.yeoxuhang.endit;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.yeoxuhang.endit.command.EndSpawnCommand;

@EventBusSubscriber
public class CommonEvents {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event){
        EndSpawnCommand.register(event.getDispatcher());
    }
}
