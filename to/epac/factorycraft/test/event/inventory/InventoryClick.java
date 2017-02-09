package to.epac.factorycraft.test.event.inventory;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		Inventory inv = event.getInventory();
		if(!inv.getTitle().equals("Custom Inventory"))
			return;
		
		if (!(event.getWhoClicked() instanceof Player))
			return;
		
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if(item.getType()==Material.COMPASS){
			player.teleport(player.getWorld().getSpawnLocation());
			player.sendMessage("You have been teleported to spawn.");
			
			player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
		}
		event.setCancelled(true);
		player.closeInventory();
	}
}