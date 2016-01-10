package com.rhota.mcplugin.listeners;

import com.rhota.mcplugin.TestCommand;
import com.rhota.mcplugin.utility.DebugUtility;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class RegisterListener {

    final private JavaPlugin p;

    public void register() {
        PluginManager pluginManager = p.getServer().getPluginManager();
        /**
         * Why this way?
         *
         * It's just easier to type in cost of some unnoticable memory for Stream.
         */

        // Legacies: Original way:
//        pluginManager.registerEvents(new BlockListeners(), p);
//        pluginManager.registerEvents(new DamageListener(), p);
//        pluginManager.registerEvents(new ExplosionListener(), p);
//        pluginManager.registerEvents(new FoodListener(), p);
//        pluginManager.registerEvents(new ItemListeners(), p);
//        pluginManager.registerEvents(new WeatherListener(), p);
//        pluginManager.registerEvents(new AchievementListener(), p);
//        pluginManager.registerEvents(new PlayerJoinListener(), p);
//        pluginManager.registerEvents(new PlayerChatListener(p), p);

        // Legacies: Cooler way
//        Arrays.stream(new Class[]{
//                BlockListeners.class,
//                DamageListener.class,
//                ExplosionListener.class,
//                FoodListener.class,
//                ItemListeners.class,
//                WeatherListener.class,
//                AchievementListener.class,
//                PlayerJoinListener.class,
//                PlayerChatListener.class
//        }).forEach((x) -> {
//            boolean isListener = false;
//            if (x.getInterfaces()[0] == Listener.class) {
//                Constructor r;
//                try {
//                    r = x.getConstructor(Plugin.class);
//                    pluginManager.registerEvents((Listener) r.newInstance(p), p);
//                    isListener = true;
//                } catch (NoSuchMethodException e) {
//                    try {
//                        r = x.getConstructor();
//                        pluginManager.registerEvents((Listener) r.newInstance(), p);
//                        isListener = true;
//                    } catch (NoSuchMethodException e1) {
//
//                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e1) {
//                        DebugUtility.toConsole(e1.getMessage());
//                    }
//                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
//                    DebugUtility.toConsole(e.getMessage());
//                }
//
//            }
//            if (!isListener)
//                DebugUtility.toConsole(x.getSimpleName(),
//                        "is not a Listener");
//        });

        /**
         * Listeners
         */
        Arrays.stream(new Listener[]{
                new BlockListeners(),
                new DamageListener(),
                new ExplosionListener(),
                new FoodListener(),
                new ItemListeners(),
                new WeatherListener(),
                new AchievementListener(),
                new PlayerJoinListener(),
                new PlayerChatListener(p)
        }).forEach((x) -> pluginManager.registerEvents(x, p));

        /**
         * Commands
         */
        Arrays.stream(new Object[][]{
                new Object[]{
                        "test",
                        new TestCommand(p)
                }
        }).forEach((x) -> {
            if (x[0] instanceof String && x[1] instanceof CommandExecutor) {
                final String name = (String) x[0];
                final CommandExecutor e = (CommandExecutor) x[1];

                p.getCommand(name).setExecutor(e);
            } else {
                DebugUtility.toConsole(x[0], " | ", x[1]);
            }
        });

    }

    public RegisterListener(JavaPlugin p) {
        this.p = p;
    }
}
