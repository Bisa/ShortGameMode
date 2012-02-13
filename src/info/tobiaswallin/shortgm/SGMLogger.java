package info.tobiaswallin.shortgm;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.entity.Player;

public class SGMLogger {
	private static Logger logger = Logger.getLogger("Minecraft");
	private static String prefix = "[SGM] ";

	public static void Message(Player player, String message) {
		player.sendMessage(prefix + message);
	}

	public static void Log(Level level, String message) {
		logger.log(level, prefix + message);
	}

}
