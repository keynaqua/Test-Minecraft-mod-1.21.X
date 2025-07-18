package net.aquakeyn.testmod.entity;

import net.aquakeyn.testmod.TestMod;
import net.aquakeyn.testmod.entity.custom.SpellProjectileEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, TestMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<SpellProjectileEntity>> SPELL_PROJECTILE =
            ENTITY_TYPES.register("spell_projectile", () ->
                    EntityType.Builder.<SpellProjectileEntity>of(SpellProjectileEntity::new, MobCategory.MISC)
                            .sized(0.25f, 0.25f)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build("spell_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
