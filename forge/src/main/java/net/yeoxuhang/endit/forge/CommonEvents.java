package net.yeoxuhang.endit.forge;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yeoxuhang.endit.command.EndSpawnCommand;

@Mod.EventBusSubscriber
public class CommonEvents {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event){
        EndSpawnCommand.getSpawn(event.getDispatcher());
        EndSpawnCommand.setSpawn(event.getDispatcher());
    }
}
