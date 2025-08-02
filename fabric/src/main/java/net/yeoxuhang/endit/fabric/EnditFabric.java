package net.yeoxuhang.endit.fabric;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.commands.CommandSourceStack;
import net.yeoxuhang.endit.Endit;
import net.fabricmc.api.ModInitializer;
import net.yeoxuhang.endit.command.EndSpawnCommand;

public class EnditFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Endit.init();
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            CommandDispatcher<CommandSourceStack> dispatcher = server.getCommands().getDispatcher();
            EndSpawnCommand.getSpawn(dispatcher);
            EndSpawnCommand.setSpawn(dispatcher);
        });
    }
}