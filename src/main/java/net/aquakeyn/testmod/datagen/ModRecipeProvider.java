package net.aquakeyn.testmod.datagen;

import net.aquakeyn.testmod.TestMod;
import net.aquakeyn.testmod.block.ModBlocks;
import net.aquakeyn.testmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider  implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BISMUTH_SMELTABLE = List.of(ModItems.RAW_BISMUTH,
                ModBlocks.BISMUTH_ORE);

        List<ItemLike> FOOD_SMELTABLE = List.of(ModItems.RAW_SPACE_COOKIE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_SPACE_COOKIE.get())
                .pattern(" P ")
                .pattern("WCW")
                .pattern(" P ")
                .define('W', Items.WHEAT)
                .define('P', Items.PUFFERFISH)
                .define('C', Items.COCOA_BEANS)
                .unlockedBy("has_raw_space_cookie", has(ModItems.RAW_SPACE_COOKIE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK)).save(recipeOutput);

        /* -- Ores Melting -- */
        oreSmelting(recipeOutput, BISMUTH_SMELTABLE, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLE, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100, "bismuth");

        /* -- Food Melting -- */
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_SPACE_COOKIE.get()),
                RecipeCategory.FOOD, ModItems.SPACE_COOKIE.get(), 0.35f, 200)
                .unlockedBy("has_raw_space_cookie", has(ModItems.SPACE_COOKIE.get())).save(recipeOutput);
    }
}
