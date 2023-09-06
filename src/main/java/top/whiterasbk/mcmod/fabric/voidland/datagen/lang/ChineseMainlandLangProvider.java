package top.whiterasbk.mcmod.fabric.voidland.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import top.whiterasbk.mcmod.fabric.voidland.VoidLandBlocks;
import top.whiterasbk.mcmod.fabric.voidland.VoidLandItems;

public class ChineseMainlandLangProvider extends FabricLanguageProvider {

    public ChineseMainlandLangProvider(FabricDataOutput output) {
        super(output, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(VoidLandBlocks.SAMPLE_BLOCK, "样本方块");
        translationBuilder.add(VoidLandItems.SAMPLE_ITEM, "样本物品");
    }
}