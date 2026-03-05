package net.Luca.firstMod.datagen;

import net.Luca.firstMod.FirstMod;
import net.Luca.firstMod.block.modBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider  extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(modBlocks.SAPPHIRE_BLOCK);
        blockWithItem(modBlocks.RAW_SAPPHIRE_BLOCK);

        blockWithItem(modBlocks.SAPPHIRE_ORE);
        blockWithItem(modBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(modBlocks.END_SAPPHIRE_ORE);
        blockWithItem(modBlocks.NETHER_SAPPHIRE_ORE);

        blockWithItem(modBlocks.SOUND_BLOCK);

        stairsBlock(((StairBlock) modBlocks.SAPPHIRE_STAIRS.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock(((SlabBlock) modBlocks.SAPPHIRE_SLAB.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()));

        buttonBlock(((ButtonBlock) modBlocks.SAPPHIRE_BUTTON.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) modBlocks.SAPPHIRE_PRESSURE_PLATE.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock(((FenceBlock) modBlocks.SAPPHIRE_FENCE.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) modBlocks.SAPPHIRE_FENCE_GATE.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock(((WallBlock) modBlocks.SAPPHIRE_WALL.get()), blockTexture(modBlocks.SAPPHIRE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) modBlocks.SAPPHIRE_DOOR.get()), modLoc("block/sapphire_door_bottom"),modLoc("block/sapphire_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) modBlocks.SAPPHIRE_TRAPDOOR.get()), modLoc("block/sapphire_trapdoor"), true,"cutout");

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
