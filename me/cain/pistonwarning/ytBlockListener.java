package me.cain.pistonwarning;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ytBlockListener extends BlockListener {
	ytMain plugin;
    
	Player player;
    public ytBlockListener(ytMain plugin) {
            plugin = this.plugin;
    }
    
    public void onBlockPlace(BlockPlaceEvent event) {
    	 if(event.getBlock().getType().equals(Material.PISTON_BASE) | event.getBlock().getType().equals(Material.PISTON_STICKY_BASE)) {
    	event.getPlayer().sendMessage(ChatColor.RED + "[WARNING] " + ChatColor.WHITE + "Pistons are buggy. Be careful when using.");
  	  if (!ytMain.permissionHandler.has(event.getPlayer(), "pwarning.info")) {
	      player.sendMessage(ChatColor.RED + "[WARNING] " + ChatColor.GRAY + event.getPlayer().getDisplayName() + " has placed a piston!");
	  }
    }
    }
}