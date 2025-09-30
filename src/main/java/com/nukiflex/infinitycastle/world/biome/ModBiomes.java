package com.nukiflex.infinitycastle.world.biome;

import com.nukiflex.infinitycastle.InfinityCastle;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;



public class ModBiomes {
    public static final RegistryKey<Biome> CASTLE_BIOME = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(InfinityCastle.MOD_ID, "castle_biome"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(CASTLE_BIOME, castleBiome(context));
    }

    public static Biome castleBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, 5, new SpawnSettings.SpawnEntry(EntityType.WOLF, 4, 4));

//        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
//        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

//        globalOverworldGeneration(biomeBuilder);
//        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
//        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
//        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);
//
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
//        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
//        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
//
//        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
//        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColor(0x7f03fc)
                        .foliageColor(0xd203fc)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.BAR_BRAWL)))
                        .build())
                .build();
    }
}
