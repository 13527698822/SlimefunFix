package com.ram.slimefunfix.listener;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ram.slimefunfix.config.Config;

public class EventListener implements Listener {
	
	//修复快捷键刷物品
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		if (player.getOpenInventory().getTitle().contains(Config.slimefun_title)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (e.getItem() == null) {
			return;
		}
		ItemStack itemStack = e.getItem();
		ItemMeta itemMeta = itemStack.getItemMeta();
		if (itemMeta.getDisplayName() == null) {
			return;
		}
		
		//修复镐子刷物品
		if (Config.pickaxe_item_name.contains(itemMeta.getDisplayName()) && itemStack.getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
			itemStack.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
			player.getInventory().setItemInHand(itemStack);
			return;
		}
		
		//修复背包刷物品
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			for (String name : Config.backpack_item_name) {
				if (itemMeta.getDisplayName().contains(name) && !itemMeta.getDisplayName().contains(Config.ender_backpack_item_name)) {
					player.closeInventory();
					break;
				}
			}
		}
	}
	
	//修复方块放置机刷物品
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onMoveItem(InventoryMoveItemEvent e) {
		if (e.getSource().getTitle().equals(Config.block_placer_item_name)) {
			e.setCancelled(true);
		}
	}
}
