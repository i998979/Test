package to.epac.factorycraft.test.event.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

public class PlayerRecieveNameTag implements Listener {
	@EventHandler
	public void onNameTagChange(AsyncPlayerReceiveNameTagEvent event) {
		Player player = event.getNamedPlayer();
		String name = player.getName();
		
		event.setTag(ChatColor.GOLD + name);
		
	}
	
	
}
