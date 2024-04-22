package limaru.ticketchecker;

import org.bukkit.entity.Player;
import com.bergerkiller.bukkit.common.entity.type.CommonMinecart;
import com.bergerkiller.bukkit.tc.controller.MinecartGroup;
import com.bergerkiller.bukkit.tc.controller.MinecartMember;
import com.bergerkiller.bukkit.tc.events.SignActionEvent;
import com.bergerkiller.bukkit.tc.events.SignChangeActionEvent;
import com.bergerkiller.bukkit.tc.signactions.SignAction;
import com.bergerkiller.bukkit.tc.signactions.SignActionType;


public class SignActionTicketCheck extends SignAction {

    @Override
    public boolean match(SignActionEvent info) {
        return info.isType("checker"); 
    }

    @Override
    public void execute(SignActionEvent info) {
        if (info.getAction() == SignActionType.GROUP_ENTER) {
            for (MinecartMember<?> m : info.getGroup()) {
                CommonMinecart<?> e = member.getEntity();
                e.getPlayerPassengers().forEach(p -> {
                    if (!checkTicket(p))
                        e.removePassenger(p);
                });
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    public boolean checkTicket(Player player) {
        // TODO: IMPORTANT, REMEMBER TO EDIT
        return false;
    }

    @Override
    public boolean build(SignChangeActionEvent event) {
        return SignBuildOptions.create()
                .setPermission("ticketchecker.build")
                .setName("ticket checker")
                .setDescription("checks if the passengers of a train have valid tickets")
                .handle(event.getPlayer());
    }
}
