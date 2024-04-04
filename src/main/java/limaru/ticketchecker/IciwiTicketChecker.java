package limaru.ticketchecker;

import org.bukkit.plugin.java.JavaPlugin;

import com.bergerkiller.bukkit.tc.signactions.SignAction;

public class IciwiTicketChecker extends JavaPlugin {

    private final SignActionTicketCheck signActionTicketCheck = new SignActionTicketCheck();

    @Override public void onEnable() {
        SignAction.register(signActionTicketCheck);
        getServer().getLogger().info("Iciwi Ticket Checker has been enabled!");

    }

    @Override public void onDisable() {
        SignAction.unregister(signActionTicketCheck);
        getServer().getLogger().info("Iciwi Ticket Checker has been disabled!");
    }
}
