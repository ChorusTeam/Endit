package net.yeoxuhang.endit.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.yeoxuhang.endit.platform.Services;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EndPlatformSpawnConfig {

    public int x = 100;
    public int y = 50;
    public int z = 0;

    private static final File CONFIG_FILE = new File(Services.PLATFORM.configFile(),"end_platform_spawn_config.json");
    private static EndPlatformSpawnConfig instance;

    public static EndPlatformSpawnConfig get() {
        if (instance == null) {
            instance = load();
        }
        return instance;
    }

    public static EndPlatformSpawnConfig load() {
        try {
            if (CONFIG_FILE.exists()) {
                return new Gson().fromJson(new FileReader(CONFIG_FILE), EndPlatformSpawnConfig.class);
            } else {
                EndPlatformSpawnConfig config = new EndPlatformSpawnConfig();
                config.save();
                return config;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new EndPlatformSpawnConfig();
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BlockPos blockpos() {
        load();
        return new BlockPos(x, y, z);
    }
}