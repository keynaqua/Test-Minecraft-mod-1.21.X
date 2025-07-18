package net.aquakeyn.testmod.block.custom;

import net.aquakeyn.testmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JuanaCropBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),  // age 0
            Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),  // age 1
            Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),  // age 2
            Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),  // age 3
            Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0), // age 4
            Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0), // age 5
            Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0), // age 6
            Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)  // age 7 (max height)
    };


    public JuanaCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.JUANA_SEEDS;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
