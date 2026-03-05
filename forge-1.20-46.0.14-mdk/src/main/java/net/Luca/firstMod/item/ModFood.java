package net.Luca.firstMod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2)
            .saturationMod(6.2f).effect(()->new MobEffectInstance(MobEffects.REGENERATION, 200, 12),8.1f).build();
    public static final FoodProperties CARBO = new FoodProperties.Builder().nutrition(10)
            .saturationMod(6).fast().build();
}
