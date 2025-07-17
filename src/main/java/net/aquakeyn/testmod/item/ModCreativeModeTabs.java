package net.aquakeyn.testmod.item;

import net.aquakeyn.testmod.TestMod;
import net.aquakeyn.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.aquakeyntestmod.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "bismuth_items_tab"))
                    .title(Component.translatable("creativetab.aquakeyntestmod.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                    }).build());

    public static final Supplier<CreativeModeTab> SUBSTANCES_TAB = CREATIVE_MODE_TAB.register("substances_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SPACE_COOKIE.get()))
                    .withTabsAfter(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "bismuth_items_tab"))
                    .title(Component.translatable("creativetab.aquakeyntestmod.substances"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_SPACE_COOKIE);
                        output.accept(ModItems.SPACE_COOKIE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
