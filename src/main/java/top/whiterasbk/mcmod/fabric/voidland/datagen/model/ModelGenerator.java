package top.whiterasbk.mcmod.fabric.voidland.datagen.model;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;
import top.whiterasbk.mcmod.fabric.voidland.collection.ModBlocks;
import top.whiterasbk.mcmod.fabric.voidland.collection.ModItems;

import static top.whiterasbk.mcmod.fabric.voidland.util.GlobalLogger.logger;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (var block : ModBlocks.all()) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
            logger.info("registered block: " + block);

            String[] idf = block.toString().split("[{}]")[1].split(":");
            String namespace = idf[0];
            String path = idf[1];

            blockStateModelGenerator.registerParentedItemModel(block, new Identifier(namespace, "block/" + path));
            logger.info("registered block item: " + namespace + ":" + path);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (var item : ModItems.all()) {
            itemModelGenerator.register(item, Models.GENERATED);
            logger.info("registered item: " + item);
        }
    }
}

