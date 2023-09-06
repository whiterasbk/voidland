package top.whiterasbk.mcmod.fabric.voidland.datagen.recipe;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.class_5267;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output) {
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
