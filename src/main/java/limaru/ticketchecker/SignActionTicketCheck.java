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
            MinecartGroup group = info.getGroup();
            for (MinecartMember<?> member : group) {
                CommonMinecart<?> minecartEntity = member.getEntity();
                minecartEntity.getPlayerPassengers().forEach(player -> {
                    if (!checkTicket(player))
                        minecartEntity.removePassenger(player);
                });
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public boolean build(SignChangeActionEvent event) {
        return true;
    }
    

    public boolean checkTicket(Player player) {
        // TODO: IMPORTANT
        return false;
    }
}
