package net.yeoxuhang.endit;

import net.yeoxuhang.endit.config.EndPlatformSpawnConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Endit
{
	public static final String MOD_ID = "endit";
	public static final String MOD_NAME = "Endit";
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

	public static void init() {
		EndPlatformSpawnConfig.load();
	}
}
