package mod.ilja615.mosaic_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Function;
import java.util.function.Supplier;

import static mod.ilja615.mosaic_blocks.ModMain.MOD_ID;

@Mod(MOD_ID)
public class ModMain
{
    public static final String MOD_ID = "mosaic_blocks";
    public static final Item.Properties ITEM_PROPERTY = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);

    public static ModMain INSTANCE;

    public ModMain()
    {
        INSTANCE = this;

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        modEventBus.addListener(this::setupCommon);

        DeferredRegister<Block> blocks = makeRegister(modEventBus, ForgeRegistries.BLOCKS);
        DeferredRegister<Item> items = makeRegister(modEventBus, ForgeRegistries.ITEMS);

        ModBlocks.MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.BOWL_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "bowl_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.CORNER_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "corner_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.CRESCENT_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "crescent_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.DOWNWARD_POINT_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "downward_point_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.DOWNWARD_SLOPE_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "downward_slope_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.FOLD_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "fold_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.FULL_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "full_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.HALF_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "half_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.HOURGLASS_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "hourglass_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.QUARTER_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "quarter_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.ROUND_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "round_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.STAIR_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "stair_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.TRIANGLE_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "triangle_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.UPWARD_POINT_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "upward_point_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.UPWARD_SLOPE_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "upward_slope_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));
        ModBlocks.WEDGE_MOSAIC_BLOCK = registerBlockAndItem(blocks, items, "wedge_mosaic_block", () -> new MosaicBlock(Block.Properties.from(Blocks.WHITE_GLAZED_TERRACOTTA)), block -> new BlockItem(block, ITEM_PROPERTY));

    }

    private void setupCommon(final FMLCommonSetupEvent event)
    {

    }

    static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> makeRegister(IEventBus modBus, IForgeRegistry<T> registry)
    {
        DeferredRegister<T> register = DeferredRegister.create(registry, MOD_ID);
        register.register(modBus);
        return register;
    }

    static <BLOCK extends Block, ITEM extends BlockItem> RegistryObject<BLOCK> registerBlockAndItem(DeferredRegister<Block> blocks, DeferredRegister<Item> items, String name, Supplier<BLOCK> blockSupplier, Function<BLOCK,ITEM> itemFactory)
    {
        RegistryObject<BLOCK> blockObject = blocks.register(name, blockSupplier);
        items.register(name, () -> itemFactory.apply(blockObject.get()));
        return blockObject;
    }
}
