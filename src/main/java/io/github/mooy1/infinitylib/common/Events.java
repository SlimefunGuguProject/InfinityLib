package io.github.mooy1.infinitylib.common;

import java.util.function.Consumer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import io.github.mooy1.infinitylib.core.AbstractAddon;

/**
 * A class for registering listeners and event handlers
 *
 * @author Mooy1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Events implements Listener {

    private static final Listener LISTENER = new Events();

    /**
     * Registers the given listener class
     */
    public static void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, AbstractAddon.instance());
    }

    /**
     * Calls the given event
     */
    public static void callEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }

    /**
     * Registers the given handler to the given event
     */
    @SuppressWarnings("unchecked")
    public static <T extends Event> void addHandler(Class<T> eventClass, EventPriority priority,
                                                    boolean ignoreCancelled, Consumer<T> handler) {
        Bukkit.getPluginManager().registerEvent(eventClass, LISTENER, priority,
                (listener, event) -> handler.accept((T) event), AbstractAddon.instance(), ignoreCancelled);
    }

}