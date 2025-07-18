package net.aquakeyn.testmod.entity.custom;

import net.aquakeyn.testmod.entity.ModEntities;
import net.aquakeyn.testmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class SpellProjectileEntity extends Projectile implements ItemSupplier {

    public SpellProjectileEntity(EntityType<SpellProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    public SpellProjectileEntity(Level level, LivingEntity shooter) {
        this(ModEntities.SPELL_PROJECTILE.value(), level);
        this.setOwner(shooter);
        this.setPos(shooter.getX(), shooter.getEyeY(), shooter.getZ());
    }

    @Override
    public void tick() {
        super.tick();

        Vec3 motion = this.getDeltaMovement();
        setPos(getX() + motion.x, getY() + motion.y, getZ() + motion.z);

        // === CLIENT SIDE ONLY ===
        if (level().isClientSide()) {
            for (int i = 0; i < 2; i++) {
                level().addParticle(
                        new DustParticleOptions(new Vector3f(1.0f, 1.0f, 0.0f), 1.0f),
                        getX(), getY(), getZ(),
                        motion.x * 0.1, motion.y * 0.1, motion.z * 0.1
                );
            }
        }

        // === SERVER SIDE ONLY ===
        if (!level().isClientSide()) {
            // Collision
            BlockPos pos = blockPosition();
            if (!level().isEmptyBlock(pos)) {
                Block block = level().getBlockState(pos).getBlock();

                if (block == Blocks.STONE) {
                    level().setBlockAndUpdate(pos, Blocks.GOLD_BLOCK.defaultBlockState());
                }

                discard(); // Supprime l'entité
            }
        }
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {}

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {}

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {}

    @Override
    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }
}
