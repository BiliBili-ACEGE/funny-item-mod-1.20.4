package net.ace;

import net.ace.funnyitemmod.block.ModBlocks;
import net.ace.funnyitemmod.command.custom.ToggleCommand;
import net.ace.funnyitemmod.command.custom.UndoCommand;
import net.ace.funnyitemmod.enchantments.ModEnchantments;
import net.ace.funnyitemmod.entity.ModEntities;
import net.ace.funnyitemmod.item.ModItemGroups;
import net.ace.funnyitemmod.item.ModItems;
import net.ace.funnyitemmod.sound.ModSounds;
import net.ace.funnyitemmod.util.ModCustomTrades;
import net.ace.funnyitemmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import java.util.logging.Logger;


public class FunnyItemMod implements ModInitializer {
	public static final String MOD_ID = "funny-item-mod";
	public static final Logger LOGGER = Logger.getLogger("funny-item-mod");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModSounds.registerSounds();
		ModEnchantments.registerModEnchantments();
		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();

		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
			// 注册自定义指令
			ToggleCommand.register(dispatcher);
			UndoCommand.register(dispatcher);
		});
	}
}