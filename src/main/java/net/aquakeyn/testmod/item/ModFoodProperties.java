package net.aquakeyn.testmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400), 0.8f).build();

    public static final FoodProperties SPACE_COOKIE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 1)
            .build();
}
