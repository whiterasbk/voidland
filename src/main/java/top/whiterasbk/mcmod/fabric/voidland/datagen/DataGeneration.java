package top.whiterasbk.mcmod.fabric.voidland.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.whiterasbk.mcmod.fabric.voidland.Blocks;
import top.whiterasbk.mcmod.fabric.voidland.Items;

public class DataGeneration implements DataGeneratorEntrypoint {

    private static final Logger logger = LoggerFactory.getLogger(DataGeneration.class);

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(MyModelGenerator::new);
    }

    private static class MyModelGenerator extends FabricModelProvider {

        public MyModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerSimpleCubeAll(Blocks.SAMPLE_BLOCK);
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            // item
            for (var item : Items.all()) {
                itemModelGenerator.register(item, Models.GENERATED);
                logger.info("registered item: " + item.getName());
            }

            // block item
            for (var block : Blocks.all()) {
                itemModelGenerator.register(Item.fromBlock(block), Models.GENERATED);
                logger.info("registered block item: " + block.getName());
            }
        }
    }

}
