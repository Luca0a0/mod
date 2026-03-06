package net.Luca.firstMod.item;

import net.Luca.firstMod.FirstMod;
import net.Luca.firstMod.block.modBlocks;
import net.Luca.firstMod.item.custom.MetalDetectorItem;
import net.Luca.firstMod.item.custom.fuelItem;
import net.Luca.firstMod.item.custom.modArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import  net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> SAP= ITEMS.register("sap",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAP= ITEMS.register("raw_sap",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR= ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> STRAWBERRY= ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFood.STRAWBERRY)));
    public static final RegistryObject<Item> CARBO= ITEMS.register("carbonara",
            () -> new Item(new Item.Properties().food(ModFood.CARBO)));
    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PINE_CONE= ITEMS.register("pine_cone",
            () -> new fuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> SAPPHIRE_SWORD= ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolsTiers.SAPPHIRE,5 ,2F,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE= ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolsTiers.SAPPHIRE,1 ,1,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE= ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolsTiers.SAPPHIRE, 6F, -3.5f,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE= ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolsTiers.SAPPHIRE,0 ,0,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL= ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolsTiers.SAPPHIRE,0 ,0,new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE_HELMET= ITEMS.register("sapphire_helmet",
            () -> new modArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.HELMET ,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE= ITEMS.register("sapphire_chestplate",
            () -> new modArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.CHESTPLATE ,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS= ITEMS.register("sapphire_leggings",
            () -> new modArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.LEGGINGS ,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS= ITEMS.register("sapphire_boots",
            () -> new modArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.BOOTS ,new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
                () -> new ItemNameBlockItem(modBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
