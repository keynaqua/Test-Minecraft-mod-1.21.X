package net.aquakeyn.testmod.datagen;

import net.aquakeyn.testmod.TestMod;
import net.aquakeyn.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());
        basicItem(ModItems.SPACE_COOKIE.get());
        basicItem(ModItems.RAW_SPACE_COOKIE.get());

        basicItem(ModItems.JUANA_SEEDS.get());
    }
}
