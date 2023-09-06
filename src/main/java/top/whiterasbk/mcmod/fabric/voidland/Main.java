package top.whiterasbk.mcmod.fabric.voidland;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.text.Text;
import top.whiterasbk.mcmod.fabric.voidland.block.SampleBlock;
import top.whiterasbk.mcmod.fabric.voidland.collection.ModBlocks;
import top.whiterasbk.mcmod.fabric.voidland.collection.ModItems;
import top.whiterasbk.mcmod.fabric.voidland.item.SampleItem;

import static net.minecraft.server.command.CommandManager.literal;

public class Main implements ModInitializer {

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        registerItems();
        registerBlocks();

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
        ModBlocks.SAMPLE_BLOCK =
                ModBlocks.registerVoidLandCustomBlock("a_voidland_sample_block", new SampleBlock(FabricBlockSettings.create().strength(4.0f)));
    }

    public void registerItems() {
        ModItems.SAMPLE_ITEM = ModItems.registerVoidLandCustomItem("a_voidland_sample_item", new SampleItem(new FabricItemSettings()));
    }
}

