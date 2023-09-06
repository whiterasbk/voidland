package top.whiterasbk.mcmod.fabric.voidland.datagen.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    // https://github.com/FabricMC/fabric/blob/435112151c0c55df4f4052077cddcb72b541b414/fabric-data-generation-api-v1/src/testmod/java/net/fabricmc/fabric/test/datagen/DataGeneratorTestEntrypoint.java#L142
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
                .method_10442("has_pickaxe", conditionsFromItem(Items.DIAMOND_PICKAXE))
                .method_10431(exporter);
    }

    public static CriterionConditions conditionsFromItem(Item item) {
         /* mc 1.20.1 public abstract class RecipeProvider implements DataProvider
         public static InventoryChangedCriterion.Conditions method_10426(ItemConvertible itemConvertible) {
            return method_10423(Builder.create().items(new ItemConvertible[]{itemConvertible}).build());
         }
        */
        return RecipeProvider.method_10426(item);
    }
}
