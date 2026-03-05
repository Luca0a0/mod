package net.Luca.firstMod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.Luca.firstMod.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class modArmorItem extends ArmorItem {
    public static final Map<ArmorMaterial, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.SAPPHIRE, List.of(
                            new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 1,
                                    false, false, true),
                            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0,
                                    false, false, false)
                            )).build();

    public modArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player){
        if(!world.isClientSide()){
            if(hasFullSuitOn(player)){
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapStatusEffects = entry.getValue(); // Questa è la lista

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                for (MobEffectInstance effect : mapStatusEffects) {
                    addStatusEffectForMaterial(player, mapArmorMaterial, effect);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(Player player,ArmorMaterial mapArmorMaterial,MobEffectInstance mapStatusEffect){
        boolean hasPLayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial,player) && !hasPLayerEffect){
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasFullSuitOn(Player player){
        ItemStack boots= player.getInventory().getArmor(0);
        ItemStack leggins= player.getInventory().getArmor(1);
        ItemStack chestplate= player.getInventory().getArmor(2);
        ItemStack helmet= player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() &&
                !leggins.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material,Player player){
        for(ItemStack armorStack : player.getInventory().armor){
            if(!(armorStack.getItem() instanceof ArmorItem))return false;
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggins = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == material && leggins.getMaterial() == material
                && chestplate.getMaterial() == material && helmet.getMaterial() ==  material;
    }

}
