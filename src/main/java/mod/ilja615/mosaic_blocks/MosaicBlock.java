package mod.ilja615.mosaic_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

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
        String itemName = player.getHeldItem(handIn).getItem().getRegistryName().toString();
        if (state.hasProperty(COLOR)) {
            if (itemName.equals("minecraft:white_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.WHITE), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:orange_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.ORANGE), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:magenta_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.MAGENTA), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:light_blue")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.LIGHT_BLUE), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:yellow_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.YELLOW), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:lime_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.LIME), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:pink_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.PINK), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:gray_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.GRAY), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:light_gray_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.LIGHT_GRAY), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:cyan_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.CYAN), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:purple_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.PURPLE), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:blue_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.BLUE), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:brown_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.BROWN), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:green_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.GREEN), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:red_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.RED), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
            if (itemName.equals("minecraft:black_dye")) {
                worldIn.setBlockState(pos, state.with(COLOR, MosaicColor.BLACK), 3);
                if (worldIn.rand.nextFloat() < 0.2f && !player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
                return ActionResultType.SUCCESS;
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
