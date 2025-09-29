package com.nukiflex.infinitycastle.world.dimension;

import com.nukiflex.infinitycastle.InfinityCastle;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.Optional;
import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> CASTLE_DIM = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(InfinityCastle.MOD_ID, "castledim"));
    public static final RegistryKey<World> CASTLE_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(InfinityCastle.MOD_ID, "castledim"));
    public static final RegistryKey<DimensionType> CASTLE_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(InfinityCastle.MOD_ID, "castledim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(CASTLE_DIM_TYPE, new DimensionType(
                OptionalLong.of(18000), // fixedTime
                false, // hasSkyLight
                false, // hasCeiling
                true, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.0f, // ambientLight
                Optional.empty(), // cloudHeight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
