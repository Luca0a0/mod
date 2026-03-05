package net.Luca.firstMod.item;

import net.Luca.firstMod.FirstMod;
import net.Luca.firstMod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolsTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEED_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAP.get())),
            new ResourceLocation(FirstMod.MOD_ID, "sap"), List.of(Tiers.NETHERITE), List.of());

}
