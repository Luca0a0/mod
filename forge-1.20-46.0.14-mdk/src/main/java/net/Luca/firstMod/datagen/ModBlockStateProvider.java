package net.Luca.firstMod.datagen;

import net.Luca.firstMod.FirstMod;
import net.Luca.firstMod.block.custom.StrawberryCropBlock;
import net.Luca.firstMod.block.modBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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

        makeStrawberryCrop((CropBlock) modBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(FirstMod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
