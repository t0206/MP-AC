package mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat;

import mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks.CheckResult;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {
    public static  HashMap<UUID, User> USERS = new HashMap<>();
    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager( );
        pm.registerEvents( new JoinLeaveListener() ,this );
        pm.registerEvents( new MoveListener() ,this );

        for(Player p :Bukkit.getOnlinePlayers())
            USERS.put( p.getUniqueId(),new User( p ) );
    }
    public static void log(CheckResult cr,User u){
        String message = "§c§lMP-AC§a "+u.getPlayer().getName()+" "+cr.getLevel().toString().toLowerCase()+cr.getType().getName()+"; "+cr.getMessage();
        for(Player p:Bukkit.getOnlinePlayers())
            if(p.hasPermission( Settings.NORIFY ))
                p.sendMessage(message);
        Bukkit.getConsoleSender().sendMessage(message);
    }
}
