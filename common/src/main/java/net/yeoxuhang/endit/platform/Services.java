package net.yeoxuhang.endit.platform;

import net.yeoxuhang.endit.Endit;
import net.yeoxuhang.endit.platform.services.IPlatformHelper;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        ServiceLoader<T> loader = ServiceLoader.load(clazz);
        Iterator<T> iterator = loader.iterator();
        if (iterator.hasNext()) {
            T service = iterator.next();
            Endit.LOGGER.debug("Loaded {} for service {}", service, clazz);
            return service;
        }
        throw new NullPointerException("Failed to load service for " + clazz.getName());
    }
}
