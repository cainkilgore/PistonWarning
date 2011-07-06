package me.cain.pistonwarning;

import java.util.logging.Logger;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.plugin.Plugin;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.*;

public class ytMain extends JavaPlugin{
	
	public String enabledstartup = "Enabled On Startup";
	public boolean enabled;
	String pname = "[LCHECKER]";
	String plugin = "Login Checker";
	String penable = "Enabled!";
	String pdisable = "Disabled!";
	String pluginMainDir = "plugins/easyMOTD";
	
	private final ytBlockListener bListener = new ytBlockListener(this);
Logger log = Logger.getLogger("Minecraft");
public static PermissionHandler permissionHandler;


	public void onDisable() {
		log.info("[PistonWarning] PistonWarning has been disabled.");
		}
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		setupPermissions();
		pm.registerEvent(Event.Type.BLOCK_PLACE, bListener, Priority.Normal, this);
		log.info("[PistonWarning] PistonWarning has been enabled.");
		log.info("[PistonWarning] Created by CainFoool");
	}
	private void setupPermissions() {
	    if (permissionHandler != null) {
	        return;
	    }
	    
	    Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
	    
	    if (permissionsPlugin == null) {
	        log.info("Permission system not detected, defaulting to OP");
	        return;
	    }
	    
	    permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	    log.info("Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}
}