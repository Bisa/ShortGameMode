package info.tobiaswallin.shortgm;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ShortGameMode extends JavaPlugin {

	private SGMCommandParser commandParser = new SGMCommandParser();
	public static Plugin thisPlugin;

	@Override
	public void onDisable() {
		SGMLogger.Log(Level.INFO, "Plugin Disabled");
	}

	@Override
	public void onEnable() {
		ShortGameMode.thisPlugin = this;
		SGMLogger.Log(Level.INFO, "Plugin Enabled");
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sgm")
				|| cmd.getName().equalsIgnoreCase("gm")) {
			return this.commandParser.Parse(sender, cmd, commandLabel, args);
		}
		return false;
	}

	public static void toggleGameMode(Player player) {
		if (player.getGameMode() == GameMode.CREATIVE)
			player.setGameMode(GameMode.SURVIVAL);
		else
			player.setGameMode(GameMode.CREATIVE);
		notifyTarget(player);
	}

	private static void notifyPlayer(Player player, Player target) {
		SGMLogger.Message(player,
				"You changed " + ChatColor.RED + target.getName() + "'s "
						+ ChatColor.WHITE + "game mode to " + ChatColor.GREEN
						+ target.getGameMode().toString() + ChatColor.WHITE
						+ ".");
	}

	public static void toggleGameMode(Player player, Player target) {
		ShortGameMode.toggleGameMode(target);
		SGMLogger.Message(player,
				"You changed " + ChatColor.RED + target.getName() + "'s "
						+ ChatColor.WHITE + "game mode to " + ChatColor.GREEN
						+ target.getGameMode().toString() + ChatColor.WHITE
						+ " mode.");
	}

	public static void setGameMode(Player player, Player target, GameMode mode) {
		if (target.getGameMode() == mode)
			return;
		target.setGameMode(mode);
		notifyTarget(target);
		notifyPlayer(player, target);
	}

	private static void notifyTarget(Player target) {
		SGMLogger.Message(target, "Your game mode changed to "
				+ ChatColor.GREEN + target.getGameMode().toString()
				+ ChatColor.WHITE + " mode.");
	}
}
