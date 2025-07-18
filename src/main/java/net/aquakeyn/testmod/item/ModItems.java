package net.aquakeyn.testmod.item;

import net.aquakeyn.testmod.TestMod;
import net.aquakeyn.testmod.block.ModBlocks;
import net.aquakeyn.testmod.item.custom.WandItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);


    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));

    public static final DeferredItem<Item> RAW_SPACE_COOKIE = ITEMS.register("raw_space_cookie",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPACE_COOKIE = ITEMS.register("space_cookie",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SPACE_COOKIE)));

    public static final DeferredItem<Item> JUANA_SEEDS = ITEMS.register("juana_seeds",
            () -> new ItemNameBlockItem(ModBlocks.JUANA_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> WAND = ITEMS.register("wand",
            () -> new WandItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
