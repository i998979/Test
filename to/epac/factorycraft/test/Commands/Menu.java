package to.epac.factorycraft.test.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You must be a player to use this comamnd!");
			return false;
		}
		
		Player player = (Player) sender;
		
		Inventory inv = Bukkit.createInventory(null, 9, "Custom Inventory");
		
		ItemStack spawnItem = nameItem(Material.COMPASS, ChatColor.AQUA + "Teleport To Spawn!");
		
		inv.setItem(4, spawnItem);
		
		player.openInventory(inv);
		
		return true;
	}
	
	private ItemStack nameItem(ItemStack item, String name){
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	private ItemStack nameItem(Material item, String name){
		return nameItem(new ItemStack(item), name);
	}
}
