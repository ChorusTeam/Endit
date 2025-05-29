package net.yeoxuhang.endit.platform;

import net.yeoxuhang.endit.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public File configFile() {
        return FabricLoader.getInstance().getConfigDir().toFile();
    }
}
