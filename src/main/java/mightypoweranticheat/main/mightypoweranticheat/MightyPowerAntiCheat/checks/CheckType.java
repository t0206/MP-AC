package mightypoweranticheat.main.mightypoweranticheat.MightyPowerAntiCheat.checks;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum  CheckType {
    SPEED("Speed", new Permission("ac.bypass"));

    private String name;
    private Permission perm;
    private CheckType(String name, Permission perm){
        this.name = name;
        this.perm = perm;
        Bukkit.getPluginManager().addPermission( perm );
    }
    public String getName(){
        return name;
    }
    public Permission getPerm(){
        return perm;
    }
}
