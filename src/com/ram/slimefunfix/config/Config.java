package com.ram.slimefunfix.config;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import com.ram.slimefunfix.Main;

public class Config {
	public static String slimefun_title;
	public static List<String> backpack_item_name;
	public static String ender_backpack_item_name;
	public static List<String> pickaxe_item_name;
	public static String block_placer_item_name;
	public static void loadConfig() {
		Main.getInstance().saveDefaultConfig();
		Main.getInstance().reloadConfig();
		FileConfiguration config = Main.getInstance().getConfig();
		slimefun_title = config.getString("slimefun_title");
		backpack_item_name = config.getStringList("backpack_item_name");
		ender_backpack_item_name = config.getString("ender_backpack_item_name");
		pickaxe_item_name = config.getStringList("pickaxe_item_name");
		block_placer_item_name = config.getString("block_placer_item_name");
	}
}
