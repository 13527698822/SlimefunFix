package com.ram.slimefunfix;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.ram.slimefunfix.command.Cmd;
import com.ram.slimefunfix.config.Config;
import com.ram.slimefunfix.listener.EventListener;

public class Main extends JavaPlugin {
	private static Plugin instance;
	private static String version = "1.0";
	public void onEnable() {
		instance = this;
		Config.loadConfig();
		Bukkit.getPluginCommand("slimefunfix").setExecutor((CommandExecutor) new Cmd());
		Bukkit.getPluginManager().registerEvents(new EventListener(), instance);
		Bukkit.getConsoleSender().sendMessage("¡ìb¡ìlSlimefunFix ¡ìfv" + version + " ¡ì7by Ram");
	}
	public static Plugin getInstance() {
		return instance;
	}
	public static String getVersion() {
		return version;
	}
}
