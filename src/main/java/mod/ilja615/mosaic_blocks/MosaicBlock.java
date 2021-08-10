package mod.ilja615.mosaic_blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.util.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;

public class MosaicBlock extends HorizontalDirectionalBlock
{
    public static final EnumProperty COLOR = EnumProperty.create("color", MosaicColor.class);

    public MosaicBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(COLOR, MosaicColor.WHITE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, COLOR);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit)
    {
        if (state.hasProperty(COLOR) && !worldIn.isClientSide) {
            if (MosaicColor.isDyeItem(player.getItemInHand(handIn).getItem())) {
                if (MosaicColor.DYE_COLOR_MAP.get(player.getItemInHand(handIn).getItem().getRegistryName().toString()) != state.getValue(COLOR)) {
                    worldIn.setBlock(pos, state.setValue(COLOR, MosaicColor.DYE_COLOR_MAP.get(player.getItemInHand(handIn).getItem().getRegistryName().toString())), 3);
                    if (worldIn.random.nextFloat() < (Config.DYE_CONSUME_CHANCE.get() / 100.0f) && !player.isCreative()) {
                        player.getItemInHand(handIn).shrink(1);
                        worldIn.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 0.5f, 1.0F);
                        for(int i = 0; i < 7; ++i) {
                            double d0 = worldIn.random.nextGaussian() * 0.02D;
                            double d1 = worldIn.random.nextGaussian() * 0.02D;
                            double d2 = worldIn.random.nextGaussian() * 0.02D;
                            ((ServerLevel)worldIn).sendParticles(ParticleTypes.SMOKE, pos.getX() + 0.5D, pos.getY() + 1.2D, pos.getZ() + 0.5D, 1,  d0, d1, d2, 0d);
                        }
                    } else {
                        worldIn.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 0.5f, 1.0F);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if (stateIn.hasProperty(COLOR) && !worldIn.isClientSide())
        {
            if (facingState.getBlock() == Blocks.WET_SPONGE)
                return stateIn.setValue(COLOR, MosaicColor.WHITE);
        }
        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state)
    {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos)
    {
        if (blockState.hasProperty(COLOR))
        {
            return ((MosaicColor)blockState.getValue(COLOR)).getIndexNumber();
        }
        return 0;
    }
}
