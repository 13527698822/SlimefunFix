package com.ram.slimefunfix.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.ram.slimefunfix.Main;
import com.ram.slimefunfix.config.Config;

public class Cmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("slimefunfix")) {
			if (args.length == 0) {
				sender.sendMessage(" ");
				sender.sendMessage("§b§lSlimefunFix §fv" + Main.getVersion() + " §7by Ram");
				return true;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				if (sender.hasPermission("slimefunfix.reload")) {
					Config.loadConfig();
					sender.sendMessage("§b§lSlimefunFix §f>> 配置文件重载完成！");
					return true;
				}
				sender.sendMessage("§b§lSlimefunFix §f>> §c你没有执行该命令的权限！");
				return true;
			}
		}
		return false;
	}
}
