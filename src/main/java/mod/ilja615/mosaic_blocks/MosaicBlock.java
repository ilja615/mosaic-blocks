package mod.ilja615.mosaic_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MosaicBlock extends HorizontalBlock
{
    public static final EnumProperty COLOR = EnumProperty.create("color", MosaicColor.class);

    public MosaicBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(COLOR, MosaicColor.WHITE));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, COLOR);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        if (state.hasProperty(COLOR) && !worldIn.isRemote) {
            if (MosaicColor.isDyeItem(player.getHeldItem(handIn).getItem())) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.DYE_COLOR_MAP.get(player.getHeldItem(handIn).getItem().getRegistryName().toString())), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                    worldIn.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 0.5f, 1.0F);
                    for(int i = 0; i < 7; ++i) {
                        double d0 = worldIn.rand.nextGaussian() * 0.02D;
                        double d1 = worldIn.rand.nextGaussian() * 0.02D;
                        double d2 = worldIn.rand.nextGaussian() * 0.02D;
                        ((ServerWorld)worldIn).spawnParticle(ParticleTypes.SMOKE, pos.getX() + 0.5D, pos.getY() + 1.2D, pos.getZ() + 0.5D, 1,  d0, d1, d2, 0d);
                    }
                } else {
                    worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 0.5f, 1.0F);
                }
                return ActionResultType.SUCCESS;
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if (stateIn.hasProperty(COLOR) && !worldIn.isRemote())
        {
            if (facingState.getBlock() == Blocks.WET_SPONGE)
                return stateIn.with(COLOR, MosaicColor.WHITE);
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
}
