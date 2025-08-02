package net.yeoxuhang.endit.util;

import com.google.common.base.Supplier;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class CommandUtils {
    public static void sendSuccess(CommandSourceStack source, Component component, boolean broadcast) {
        try {
            source.getClass()
                    .getMethod("method_9226", java.util.function.Supplier.class, boolean.class)
                    .invoke(source, (Supplier<Component>) () -> component, broadcast);
        } catch (NoSuchMethodException e) {
            try {
                source.getClass()
                        .getMethod("method_9226", Component.class, boolean.class)
                        .invoke(source, component, broadcast);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
