package top.whiterasbk.mcmod.fabric.voidland.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import top.whiterasbk.mcmod.fabric.voidland.ModBlocks;
import top.whiterasbk.mcmod.fabric.voidland.ModItems;
import top.whiterasbk.mcmod.fabric.voidland.VoidLandMain;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import static top.whiterasbk.mcmod.fabric.voidland.util.GlobalLogger.logger;

public class ExistingEnglishLangProvider extends FabricLanguageProvider {

    public ExistingEnglishLangProvider(FabricDataOutput output) {
        super(output, "en_us");
    }

    public boolean requireExisting = false;

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.SAMPLE_BLOCK, "A voidland sample block");
        translationBuilder.add(ModItems.SAMPLE_ITEM, "A voidland sample item");

        try {
            Optional<Path> path = dataOutput.getModContainer().findPath("assets/" + VoidLandMain.modid + "/lang/en_us.base.json");

            if (path.isPresent()) {
                translationBuilder.add(path.get());
            } else {
                String msg = "The existing language file could not be found in the " + VoidLandMain.modid + " assets!";
                if (requireExisting) {
                    throw new RuntimeException(msg);
                } else logger.error(msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

