package io.papermc.paper.event.entity;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Tameable;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

/**
 * Called when a {@link Tameable} dies and sends a death message.
 */
@NullMarked
public class TameableDeathMessageEvent extends EntityEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private Component deathMessage;
    private boolean cancelled;

    @ApiStatus.Internal
    public TameableDeathMessageEvent(final Tameable tameable, final Component deathMessage) {
        super(tameable);
        this.deathMessage = deathMessage;
    }

    /**
     * Set the death message that appears to the owner of the tameable.
     *
     * @param deathMessage Death message to appear
     */
    public void deathMessage(final Component deathMessage) {
        this.deathMessage = deathMessage;
    }

    /**
     * Get the death message that appears to the owner of the tameable.
     *
     * @return Death message to appear
     */
    public Component deathMessage() {
        return this.deathMessage;
    }

    @Override
    public Tameable getEntity() {
        return (Tameable) super.getEntity();
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(final boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
