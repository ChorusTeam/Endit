package net.yeoxuhang.endit.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.yeoxuhang.endit.config.EndPlatformSpawnConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {
    @Shadow
    @Mutable
    @Final
    public static BlockPos END_SPAWN_POINT;

    @Inject(method = "tick", at = @At("TAIL"))
    private void onInit(CallbackInfo ci) {
        END_SPAWN_POINT = EndPlatformSpawnConfig.get().blockpos();
    }
}
