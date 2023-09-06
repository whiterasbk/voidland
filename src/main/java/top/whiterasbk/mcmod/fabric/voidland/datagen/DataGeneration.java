package top.whiterasbk.mcmod.fabric.voidland.datagen;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.class_5267;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.whiterasbk.mcmod.fabric.voidland.VoidLandBlocks;
import top.whiterasbk.mcmod.fabric.voidland.VoidLandItems;

import java.util.function.Consumer;

public class DataGeneration implements DataGeneratorEntrypoint {

    private static final Logger logger = LoggerFactory.getLogger(DataGeneration.class);

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(VoidLandModelGenerator::new);
        pack.addProvider(VoidLandExistingEnglishLangProvider::new);
        pack.addProvider(VoidLandChineseMainlandLangProvider::new);
        pack.addProvider(VoidLandRecipeProvider::new);
    }

    private static class VoidLandModelGenerator extends FabricModelProvider {

        public VoidLandModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            for (var block : VoidLandBlocks.all()) {
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
            for (var item : VoidLandItems.all()) {
                itemModelGenerator.register(item, Models.GENERATED);
                logger.info("registered item: " + item);
            }
        }
    }

    private static class VoidLandExistingEnglishLangProvider extends FabricLanguageProvider {

        public VoidLandExistingEnglishLangProvider(FabricDataOutput output) {
            super(output, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(VoidLandBlocks.SAMPLE_BLOCK, "A voidland sample block");
            translationBuilder.add(VoidLandItems.SAMPLE_ITEM, "A voidland sample item");
        }
    }

    private static class VoidLandChineseMainlandLangProvider extends FabricLanguageProvider {

        public VoidLandChineseMainlandLangProvider(FabricDataOutput output) {
            super(output, "zh_cn");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(VoidLandBlocks.SAMPLE_BLOCK, "样本方块");
            translationBuilder.add(VoidLandItems.SAMPLE_ITEM, "样本物品");
        }
    }

    private static class VoidLandRecipeProvider extends FabricRecipeProvider {
        public VoidLandRecipeProvider(FabricDataOutput output) {
            super(output);
        }

        // https://github.com/FabricMC/fabric/blob/fd3c43cbb20f28b1b938bb602b485c8cba60dd5f/fabric-data-generation-api-v1/src/testmod/java/net/fabricmc/fabric/test/datagen/DataGeneratorTestEntrypoint.java#L124
        @Override
        public void method_10419(Consumer<RecipeJsonProvider> exporter) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND_BLOCK)
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .input(DefaultCustomIngredients.nbt(new ItemStack(Items.DIAMOND_PICKAXE), false))
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .input(Ingredient.ofItems(Items.DIAMOND_PICKAXE))
                    .method_10442("has_pickaxe", new CriterionConditions() {
                        @Override
                        public Identifier method_806() {
                            return new Identifier("voidland", "a_voidland_sample_item");
                        }

                        @Override
                        public JsonObject method_807(class_5267 arg) {
                            return null;
                        }
                    })
                    .method_10431(exporter);




        }
    }
}
