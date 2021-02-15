package mod.ilja615.mosaic_blocks;

import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;

import java.util.HashMap;
import java.util.Map;


public enum MosaicColor implements IStringSerializable
{
    WHITE("white"),
    ORANGE("orange"),
    MAGENTA("magenta"),
    LIGHT_BLUE("light_blue"),
    YELLOW("yellow"),
    LIME("lime"),
    PINK("pink"),
    GRAY("gray"),
    LIGHT_GRAY("light_gray"),
    CYAN("cyan"),
    PURPLE("purple"),
    BLUE("blue"),
    BROWN("brown"),
    GREEN("green"),
    RED("red"),
    BLACK("black");

    private final String name;

    private MosaicColor(String name)
    {
        this.name = name;
    }

    @Override
    public String getString() {
        return this.name;
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
