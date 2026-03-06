package net.Luca.firstMod.item;

import net.Luca.firstMod.FirstMod;
import net.Luca.firstMod.block.modBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TRY_TAB =CREATIVE_MOD_TAB.register("try_tab",
            () -> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.SAP.get()))
                    .title(Component.translatable("creativetab.try_tab"))
                    .displayItems((pParameters,pOutput) -> {
                        pOutput.accept(ModItems.SAP.get());
                        pOutput.accept(ModItems.RAW_SAP.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.SAPPHIRE_STAFF.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.CARBO.get());
                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(ModItems.SAPPHIRE_HOE.get());

                        pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                        pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                        pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                        pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());

                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());

                        pOutput.accept(modBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(modBlocks.RAW_SAPPHIRE_BLOCK.get());

                        pOutput.accept(modBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(modBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(modBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(modBlocks.END_SAPPHIRE_ORE.get());

                        pOutput.accept(modBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModItems.PINE_CONE.get());

                        pOutput.accept(modBlocks.SAPPHIRE_STAIRS.get());
                        pOutput.accept(modBlocks.SAPPHIRE_SLAB.get());
                        pOutput.accept(modBlocks.SAPPHIRE_FENCE.get());
                        pOutput.accept(modBlocks.SAPPHIRE_FENCE_GATE.get());
                        pOutput.accept(modBlocks.SAPPHIRE_WALL.get());
                        pOutput.accept(modBlocks.SAPPHIRE_BUTTON.get());
                        pOutput.accept(modBlocks.SAPPHIRE_DOOR.get());
                        pOutput.accept(modBlocks.SAPPHIRE_TRAPDOOR.get());
                        pOutput.accept(modBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                    })
                    .build()
    );



    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TAB.register(eventBus);
    }
}
