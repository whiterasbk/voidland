package top.whiterasbk.mcmod.fabric.voidland;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import org.slf4j.Logger;

import static net.minecraft.server.command.CommandManager.literal;

public class VoidLandMain implements ModInitializer {

    private static final Logger logger = LogUtils.getLogger();

    public static final Item VOIDLAND_ITEM = new Item(new FabricItemSettings());

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(literal("voidland")
                .executes(context -> {
                    context.getSource().sendError(Text.literal("hello voidland"));
                    return 1;
                })
            )
        );
    }
}

