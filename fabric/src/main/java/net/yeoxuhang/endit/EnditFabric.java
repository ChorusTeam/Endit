package net.yeoxuhang.endit;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.commands.CommandSourceStack;
import net.yeoxuhang.endit.command.EndSpawnCommand;

public class EnditFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Endit.init();
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            CommandDispatcher<CommandSourceStack> dispatcher = server.getCommands().getDispatcher();
            EndSpawnCommand.register(dispatcher);
        });
    }
}
