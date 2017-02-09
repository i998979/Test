package to.epac.factorycraft.test;

import java.util.logging.Logger;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import to.epac.factorycraft.test.Commands.Hello;
import to.epac.factorycraft.test.Commands.Info;
import to.epac.factorycraft.test.Commands.Menu;
import to.epac.factorycraft.test.event.block.BlockBreak;
import to.epac.factorycraft.test.event.inventory.InventoryClick;
import to.epac.factorycraft.test.event.other.ProjectileHit;
import to.epac.factorycraft.test.event.player.PlayerJoin;
import to.epac.factorycraft.test.event.player.PlayerRecieveNameTag;

public class Test extends JavaPlugin{

	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerCommands();
		registerEvents();
		registerPermissions();
		
		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
	}
	
	public void onDisable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
	}
	
	public void registerCommands(){
		getCommand("hello").setExecutor(new Hello(this));
		getCommand("menu").setExecutor(new Menu());
		getCommand("info").setExecutor(new Info());
	}
	
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new PlayerJoin(this), this);
		
		pm.registerEvents(new InventoryClick(), this);
		pm.registerEvents(new ProjectileHit(), this);
		pm.registerEvents(new PlayerRecieveNameTag(), this);
		
	}
	
	private void registerPermissions(){
		Permission p = new Permission("Test.Snowball");
		PluginManager pm = getServer().getPluginManager();
		
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Permission registered.");
		
		pm.addPermission(p);
	}
	
}
