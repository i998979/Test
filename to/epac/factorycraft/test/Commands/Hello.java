package to.epac.factorycraft.test.Commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.epac.factorycraft.test.Test;

public class Hello implements CommandExecutor {
	
	private Test plugin;

	public Hello(Test pl) {
		plugin = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
			if (!(sender instanceof Player)){
				sender.sendMessage(ChatColor.RED + "You must be a player to use this comamnd!");
				return false;
			}
			
			Player player = (Player) sender;
			player.sendMessage(ChatColor.AQUA + "You did the command! " + player.getName() + "!");
			
			List<String> serverAdmins = plugin.getConfig().getStringList("Server Admins");
			
			player.sendMessage("The server admins are:");
			for(String admin: serverAdmins){
				player.sendMessage(admin);
			}
			
			return true;
	}
}
