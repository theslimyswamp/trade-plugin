package org.rolypolyvole.trading;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.rolypolyvole.trading.commands.TradeCommand;
import org.rolypolyvole.trading.events.TradeMenuClose;
import org.rolypolyvole.trading.events.TradeMenuConfirmOrCancel;
import org.rolypolyvole.trading.events.TradeMenuInteract;
import org.rolypolyvole.trading.trade.Trade;

import java.util.HashMap;

public final class Trading extends JavaPlugin {
    public final HashMap<Player, Player> tradingPlayers = new HashMap<>();
    public final HashMap<Inventory, Trade> invToTradeMap = new HashMap<>();

    @Override
    public void onEnable() {
        PluginCommand tradeCommand = getCommand("trade");
        TradeCommand command = new TradeCommand(this);

        assert tradeCommand != null;
        tradeCommand.setExecutor(command);
        tradeCommand.setTabCompleter(command);

        Bukkit.getPluginManager().registerEvents(new TradeMenuInteract(this), this);
        Bukkit.getPluginManager().registerEvents(new TradeMenuClose(this), this);
        Bukkit.getPluginManager().registerEvents(new TradeMenuConfirmOrCancel(this), this);
    }
}
