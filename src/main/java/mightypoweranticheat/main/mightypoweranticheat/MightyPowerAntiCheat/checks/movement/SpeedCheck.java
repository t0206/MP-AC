package mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks.movement;

import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.Distance;
import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.Settings;
import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.User;
import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks.CheckResult;
import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks.CheckType;
import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks.Level;


public class SpeedCheck {
    public static  final CheckResult PASS =  new CheckResult( Level.PASSED,null , CheckType.SPEED);
    public static CheckResult runCheck(Distance d,User u){
        Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff(): d.getzDiff());
        if( xz_speed> Settings.MAX_XZ_SPEED ){
            return new CheckResult( Level.DEFINITLY, "tried to move faster than normal, speed=("+xz_speed.toString()+"), maz=("+Settings.MAX_XZ_SPEED,CheckType.SPEED );
        }
        return PASS;

    }
}
