package net.yeoxuhang.endit.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.yeoxuhang.endit.config.EndPlatformSpawnConfig;

public class EndSpawnCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("setendspawn")
                .requires(source -> source.hasPermission(2)) // OP only
                .then(Commands.argument("pos", BlockPosArgument.blockPos())
                        .executes(context -> {
                            try {
                                BlockPos pos = BlockPosArgument.getBlockPos(context, "pos");
                                int x = pos.getX();
                                int y = pos.getY();
                                int z = pos.getZ();

                                if (y <= 1 || y > 257) {
                                    context.getSource().sendFailure(Component.translatable("endit.command.ycoordinate"));
                                    return 0;
                                }

                                ServerLevel endWorld = context.getSource().getServer().getLevel(Level.END);
                                if (endWorld == null || !endWorld.getWorldBorder().isWithinBounds(pos)) {
                                    context.getSource().sendFailure(Component.translatable("argument.pos.outofworld"));
                                    return 0;
                                }

                                EndPlatformSpawnConfig config = EndPlatformSpawnConfig.get();
                                config.x = x;
                                config.y = y;
                                config.z = z;
                                config.save();

                                context.getSource().sendSuccess(
                                        () -> Component.translatable("endit.command.success", x, y, z),
                                        true
                                );
                                return 1;

                            } catch (Exception e) {
                                e.printStackTrace();
                                context.getSource().sendFailure(Component.translatable("endit.command.failed", e.getMessage()));
                                return 0;
                            }
                        })
                )
        );
    }
}