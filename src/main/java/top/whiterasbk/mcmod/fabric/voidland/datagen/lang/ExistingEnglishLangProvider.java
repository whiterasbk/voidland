package top.whiterasbk.mcmod.fabric.voidland.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import top.whiterasbk.mcmod.fabric.voidland.VoidLandBlocks;
import top.whiterasbk.mcmod.fabric.voidland.VoidLandItems;

public class ExistingEnglishLangProvider extends FabricLanguageProvider {

    public ExistingEnglishLangProvider(FabricDataOutput output) {
        super(output, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(VoidLandBlocks.SAMPLE_BLOCK, "A voidland sample block");
        translationBuilder.add(VoidLandItems.SAMPLE_ITEM, "A voidland sample item");
    }
}

