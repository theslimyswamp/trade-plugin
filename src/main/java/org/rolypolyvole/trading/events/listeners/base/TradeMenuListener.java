package org.rolypolyvole.trading.events.listeners.base;

import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.rolypolyvole.trading.Trading;

public abstract class TradeMenuListener implements Listener {
    protected final Trading main;
    public TradeMenuListener(Trading main) {
        this.main = main;
    }

    protected boolean isTradeGUI(Inventory gui) {
        return gui != null && main.invToTradeMap.containsKey(gui);
    }
}
