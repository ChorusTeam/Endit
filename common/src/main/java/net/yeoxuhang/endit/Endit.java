package net.yeoxuhang.endit;

import net.yeoxuhang.endit.config.EndPlatformSpawnConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Endit
{
	public static final String MOD_ID = "endit";
	public static final String MOD_NAME = "Endit";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static void init() {
		EndPlatformSpawnConfig.load();
	}
}
