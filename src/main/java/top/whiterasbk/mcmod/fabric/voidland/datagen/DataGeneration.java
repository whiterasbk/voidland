package top.whiterasbk.mcmod.fabric.voidland.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import top.whiterasbk.mcmod.fabric.voidland.datagen.lang.ChineseMainlandLangProvider;
import top.whiterasbk.mcmod.fabric.voidland.datagen.lang.ExistingEnglishLangProvider;
import top.whiterasbk.mcmod.fabric.voidland.datagen.model.ModelGenerator;
import top.whiterasbk.mcmod.fabric.voidland.datagen.recipe.RecipeProvider;

public class DataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(ExistingEnglishLangProvider::new);
        pack.addProvider(ChineseMainlandLangProvider::new);
//        pack.addProvider(RecipeProvider::new);
    }

}
