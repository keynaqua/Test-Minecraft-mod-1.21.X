package net.aquakeyn.testmod;

import net.aquakeyn.testmod.entity.ModEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = TestMod.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = TestMod.MOD_ID, value = Dist.CLIENT)
public class TestModClient {
    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.SPELL_PROJECTILE.value(),
                    context -> new ThrownItemRenderer<>(context, 1.0F, true));
        });
    }

}
