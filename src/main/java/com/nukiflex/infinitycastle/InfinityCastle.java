package com.nukiflex.infinitycastle;

import com.nukiflex.infinitycastle.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfinityCastle implements ModInitializer {
	public static final String MOD_ID = "infinitycastle";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        ModBlocks.registerModBlocks();

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.RED_NETHER_BRICKS)
                .lightWithItem(Items.NETHER_STAR)
                .destDimID(Identifier.of(InfinityCastle.MOD_ID, "castledim"))
                .tintColor(255,0, 0)
                .registerPortal();

		LOGGER.info("Hello Fabric world!");
	}
}