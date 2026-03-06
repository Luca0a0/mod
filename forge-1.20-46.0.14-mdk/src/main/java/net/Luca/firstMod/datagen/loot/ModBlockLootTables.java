package net.Luca.firstMod.datagen.loot;

import net.Luca.firstMod.block.custom.StrawberryCropBlock;
import net.Luca.firstMod.block.modBlocks;
import net.Luca.firstMod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(modBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(modBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(modBlocks.SOUND_BLOCK.get());

        this.add(modBlocks.SAPPHIRE_ORE.get(),
                block -> createCopperLIkeOreDrops(modBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAP.get()));
        this.add(modBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLIkeOreDrops(modBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAP.get()));
        this.add(modBlocks.END_SAPPHIRE_ORE.get(),
                block -> createCopperLIkeOreDrops(modBlocks.END_SAPPHIRE_ORE.get(), ModItems.RAW_SAP.get()));
        this.add(modBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createCopperLIkeOreDrops(modBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.RAW_SAP.get()));

        this.dropSelf(modBlocks.SAPPHIRE_STAIRS.get());
        this.dropSelf(modBlocks.SAPPHIRE_BUTTON.get());
        this.dropSelf(modBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.dropSelf(modBlocks.SAPPHIRE_TRAPDOOR.get());
        this.dropSelf(modBlocks.SAPPHIRE_FENCE.get());
        this.dropSelf(modBlocks.SAPPHIRE_FENCE_GATE.get());
        this.dropSelf(modBlocks.SAPPHIRE_WALL.get());

        this.add(modBlocks.SAPPHIRE_SLAB.get(),
                block -> createSlabItemTable(modBlocks.SAPPHIRE_SLAB.get()));
        this.add(modBlocks.SAPPHIRE_DOOR.get(),
                block -> createDoorTable(modBlocks.SAPPHIRE_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(modBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE,5));

        this.add(modBlocks.STRAWBERRY_CROP.get(),createCropDrops(modBlocks.STRAWBERRY_CROP.get(),ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));

    }

    protected LootTable.Builder createCopperLIkeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return modBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
