package net.yeoxuhang.endit.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.BaseComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.yeoxuhang.endit.Endit;
import net.yeoxuhang.endit.config.EndPlatformSpawnConfig;
import net.yeoxuhang.endit.util.CommandUtils;

public class EndSpawnCommand {

    public static void setSpawn(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("setendspawn")
                .requires(source -> source.hasPermission(2)) // OP only
                .then(Commands.argument("pos", BlockPosArgument.blockPos())
                        .executes(context -> {
                            try {
                                BlockPos pos = BlockPosArgument.getOrLoadBlockPos(context, "pos");
                                int x = pos.getX();
                                int y = pos.getY();
                                int z = pos.getZ();

                                if (y <= 1 || y > 257) {
                                    context.getSource().sendFailure(new TranslatableComponent("Y coordinate must be between 2 and 257."));
                                    return 0;
                                }

                                ServerLevel endWorld = context.getSource().getServer().getLevel(Level.END);
                                if (endWorld == null || !endWorld.getWorldBorder().isWithinBounds(pos)) {
                                    context.getSource().sendFailure(new TranslatableComponent("Position is outside the End world border."));
                                    return 0;
                                }

                                EndPlatformSpawnConfig config = EndPlatformSpawnConfig.get();
                                config.x = x;
                                config.y = y;
                                config.z = z;
                                config.save();

                                CommandUtils.sendSuccess(context.getSource(),
                                        new TranslatableComponent("Set the end spawn point to %s, %s, %s", x, y, z),
                                        true
                                );
                                Endit.LOGGER.info("Set the end spawn point to %s, %s, %s", x, y, z);

                                return 1;

                            } catch (Exception e) {
                                e.printStackTrace();
                                context.getSource().sendFailure(new TranslatableComponent("Command error: %s", e.getMessage()));
                                return 0;
                            }
                        })
                )
                .then(Commands.literal("default")
                        .executes(context -> {
                            EndPlatformSpawnConfig config = EndPlatformSpawnConfig.get();
                            config.x = 100;
                            config.y = 50;
                            config.z = 0;
                            config.save();

                            CommandUtils.sendSuccess(context.getSource(),
                                    new TranslatableComponent("Set the end spawn point to %s, %s, %s", config.x, config.y, config.z),
                                    true
                            );
                            Endit.LOGGER.info("Set the end spawn point to %s, %s, %s", config.x, config.y, config.z);
                            return 1;
                        })
                )
        );
    }

    public static void getSpawn(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("getendspawn")
                .requires(source -> source.hasPermission(2))
                .executes(context -> {
                    EndPlatformSpawnConfig config = EndPlatformSpawnConfig.get();
                    int x = config.x;
                    int y = config.y;
                    int z = config.z;

                    CommandUtils.sendSuccess(context.getSource(),
                            new TranslatableComponent("Current End platform spawn is at %s, %s, %s", x, y, z),
                            false
                    );
                    Endit.LOGGER.info("Current End platform spawn is at %s, %s, %s", x, y, z);
                    return 1;
                })
        );
    }
}