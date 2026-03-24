package net.Luca.firstMod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.Luca.firstMod.FirstMod;
import net.Luca.firstMod.block.ModBlocks;
import net.Luca.firstMod.item.ModItems;
import net.Luca.firstMod.villager.ModVillager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrade(VillagerTradesEvent event){
         if(event.getType() == VillagerProfession.FARMER){
             Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

             //level 1
             trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 2),
                     new ItemStack(ModItems.STRAWBERRY.get(), 12),
                     10, 8, 0.02f));

             // Level 2
             trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 5),
                     new ItemStack(ModItems.CORN.get(), 6),
                     5, 9, 0.035f));

             // Level 3
             trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.GOLD_INGOT, 8),
                     new ItemStack(ModItems.CORN_SEEDS.get(), 2),
                     2, 12, 0.075f));

             trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.GUNPOWDER, 10),
                     new ItemStack(Items.TNT, 4),
                     2, 12, 0.075f));
         }

         if(event.getType() == VillagerProfession.LIBRARIAN) {
             Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
             ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.MENDING, 1));

             trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.DIAMOND, 16),
                     enchantedBook, 1, 1, 0.075f
             ));
         }

         if(event.getType() == ModVillager.SOUND_MASTER.get()){
             Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

             //level 1
             trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 16),
                     new ItemStack(ModBlocks.SOUND_BLOCK.get(), 1),
                     2, 8, 0.02f));
             trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 16),
                     new ItemStack(Items.JUKEBOX, 1),
                     2, 8, 0.02f));
             trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 8),
                     new ItemStack(Items.JUKEBOX, 1),
                     2, 8, 0.02f));
             trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 8),
                     new ItemStack(Items.MUSIC_DISC_WAIT, 1),
                     2, 8, 0.02f));
             trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 8),
                     new ItemStack(Items.MUSIC_DISC_13, 1),
                     2, 8, 0.02f));
             //level 2
             trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 8),
                     new ItemStack(Items.MUSIC_DISC_5, 1),
                     2, 8, 0.02f));
             trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 8),
                     new ItemStack(Items.MUSIC_DISC_11, 1),
                     2, 8, 0.02f));
             trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                     new ItemStack(Items.EMERALD, 8),
                     new ItemStack(Items.MUSIC_DISC_FAR, 1),
                     2, 8, 0.02f));
         }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrader(WandererTradesEvent  event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD,12),
                new ItemStack(ModItems.SAPPHIRE_BOOTS.get(),1),
                3,2,0.2f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD,24),
                new ItemStack(ModItems.METAL_DETECTOR.get(),1),
                2,12,0.15f
        ));
    }
}
