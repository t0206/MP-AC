package mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat;

import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks.CheckResult;
import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks.movement.SpeedCheck;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    @EventHandler
    public  void onMove(PlayerMoveEvent e){
        User u = Main.USERS.get( e.getPlayer().getUniqueId() );
        Distance d= new Distance( e );
        CheckResult speed = SpeedCheck.runCheck( d,u );
        if(speed.failed()){
            e.setTo( e.getFrom() );
            Main.log(speed,u);
        }
    }
}
