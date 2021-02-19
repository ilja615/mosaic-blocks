package mod.ilja615.mosaic_blocks;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config
{
    private static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec config;

    static
    {
        init(builder);

        config = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path)
    {
        System.out.println("Loading config: "+path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        System.out.println("Built config: "+path);
        file.load();
        System.out.println("Loaded config: "+path);
        config.setConfig(file);
    }

    public static ForgeConfigSpec.IntValue DYE_CONSUME_CHANCE;

    public static void init(ForgeConfigSpec.Builder builder)
    {
        builder.comment("The configuration for the Mosaic Blocks mod");

        DYE_CONSUME_CHANCE = builder
                .comment("The chance that the dye will be consumed when painting a mosaic block in the survival mode. \n" +
                        "0 is that it will never consume, and 100 that it will always consume. \n" +
                        "20 is the default value and that is the same chance as an Ender Eye breaking, for comparison.")
                .defineInRange("value.dye_consume_chance", 20, 0, 100);
    }
}
