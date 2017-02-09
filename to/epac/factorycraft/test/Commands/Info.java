package to.epac.factorycraft.test.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class Info implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You must be a player to use this comamnd!");
			return false;
		}
		
		Player player = (Player) sender;
		PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer
				.a("{\"text\":\"Click here to view the server info\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.youtube.com/user/i998979\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"CLICK ME\"}]}}}"));
		
		connection.sendPacket(packet);
		return true;
	}
}
