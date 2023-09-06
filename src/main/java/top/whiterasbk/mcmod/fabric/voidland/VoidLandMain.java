package top.whiterasbk.mcmod.fabric.voidland;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import top.whiterasbk.mcmod.fabric.voidland.block.SampleBlock;
import top.whiterasbk.mcmod.fabric.voidland.item.SampleItem;

import static net.minecraft.server.command.CommandManager.literal;

public class VoidLandMain implements ModInitializer {
    public static final String modid = "voidland";
    public static final String namespace = modid;

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        registerBlocks();
        registerItems();

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(literal("voidland")
                .executes(context -> {
                    context.getSource().sendError(Text.literal("hello voidland"));
                    return 1;
                })
            )
        );

    }

    public void registerBlocks() {

        ModBlocks.SAMPLE_BLOCK = Registry.register(Registries.BLOCK, new Identifier(namespace, "a_voidland_sample_block"),
                new SampleBlock(FabricBlockSettings.create().strength(4.0f)));
        Registry.register(Registries.ITEM, new Identifier(namespace, "a_voidland_sample_block"),
                new BlockItem(ModBlocks.SAMPLE_BLOCK, new FabricItemSettings()));

    }

    public void registerItems() {
        ModItems.SAMPLE_ITEM =
                Registry.register(Registries.ITEM, new Identifier(namespace, "a_voidland_sample_item"),
                        new SampleItem(new FabricItemSettings()));

    }
}

