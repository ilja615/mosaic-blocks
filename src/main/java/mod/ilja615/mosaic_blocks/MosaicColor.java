package mod.ilja615.mosaic_blocks;

import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;

import java.util.HashMap;
import java.util.Map;


public enum MosaicColor implements IStringSerializable
{
    WHITE("white", 0),
    ORANGE("orange", 1),
    MAGENTA("magenta", 2),
    LIGHT_BLUE("light_blue", 3),
    YELLOW("yellow", 4),
    LIME("lime", 5),
    PINK("pink", 6),
    GRAY("gray", 7),
    LIGHT_GRAY("light_gray", 8),
    CYAN("cyan", 9),
    PURPLE("purple", 10),
    BLUE("blue", 11),
    BROWN("brown", 12),
    GREEN("green", 13),
    RED("red", 14),
    BLACK("black", 15);

    private final String name;
    private final int indexNumber;


    private MosaicColor(String name, int indexNumber)
    {
        this.name = name; this.indexNumber = indexNumber;
    }

    @Override
    public String getString() {
        return this.name;
    }

    public int getIndexNumber() {
        return this.indexNumber;
    }

    public static boolean isDyeItem(Item item)
    {
        return
            item.getRegistryName().toString().equals("minecraft:white_dye") ||
            item.getRegistryName().toString().equals("minecraft:orange_dye") ||
            item.getRegistryName().toString().equals("minecraft:magenta_dye") ||
            item.getRegistryName().toString().equals("minecraft:light_blue_dye") ||
            item.getRegistryName().toString().equals("minecraft:yellow_dye") ||
            item.getRegistryName().toString().equals("minecraft:lime_dye") ||
            item.getRegistryName().toString().equals("minecraft:pink_dye") ||
            item.getRegistryName().toString().equals("minecraft:gray_dye") ||
            item.getRegistryName().toString().equals("minecraft:light_gray_dye") ||
            item.getRegistryName().toString().equals("minecraft:cyan_dye") ||
            item.getRegistryName().toString().equals("minecraft:purple_dye") ||
            item.getRegistryName().toString().equals("minecraft:blue_dye") ||
            item.getRegistryName().toString().equals("minecraft:brown_dye") ||
            item.getRegistryName().toString().equals("minecraft:green_dye") ||
            item.getRegistryName().toString().equals("minecraft:red_dye") ||
            item.getRegistryName().toString().equals("minecraft:black_dye");
    }

    public static final Map<String, MosaicColor> DYE_COLOR_MAP = new HashMap<String, MosaicColor>() {{
        put("minecraft:white_dye", WHITE);
        put("minecraft:orange_dye", ORANGE);
        put("minecraft:magenta_dye", MAGENTA);
        put("minecraft:light_blue_dye", LIGHT_BLUE);
        put("minecraft:yellow_dye", YELLOW);
        put("minecraft:lime_dye", LIME);
        put("minecraft:pink_dye", PINK);
        put("minecraft:gray_dye", GRAY);
        put("minecraft:light_gray_dye", LIGHT_GRAY);
        put("minecraft:cyan_dye", CYAN);
        put("minecraft:purple_dye", PURPLE);
        put("minecraft:blue_dye", BLUE);
        put("minecraft:brown_dye", BROWN);
        put("minecraft:green_dye", GREEN);
        put("minecraft:red_dye", RED);
        put("minecraft:black_dye", BLACK);
    }};
}
