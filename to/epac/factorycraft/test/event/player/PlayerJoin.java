package to.epac.factorycraft.test.event.player;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import to.epac.factorycraft.test.Test;

public class PlayerJoin implements Listener {
	
	private Test plugin;
	
	public PlayerJoin(Test pl){
		plugin = pl;
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("Welcome Message"));
		
		Player player = event.getPlayer();
		
		player.sendMessage(welcomeMessage);
		
		PacketPlayOutTitle welcomeTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE,
				ChatSerializer.a("{\"text\":\"Welcome to the server!\",\"color\":\"gold\",\"bold\":true}"), 20, 40, 30);
		PacketPlayOutTitle welcomeSubTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE,
				ChatSerializer.a("{\"text\":\"Enjoy your stay\",\"color\":\"dark_aqua\",\"italic\":true,\"underlined\":true}"), 20, 40, 30);
		
		PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
		connection.sendPacket(welcomeTitle);
		connection.sendPacket(welcomeSubTitle);
	}
}
