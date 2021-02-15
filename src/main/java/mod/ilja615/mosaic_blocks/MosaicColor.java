package mod.ilja615.mosaic_blocks;

import net.minecraft.util.IStringSerializable;

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
}
