package top.whiterasbk.mcmod.fabric.voidland.collection;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import top.whiterasbk.mcmod.fabric.voidland.voidland;

public class VoidLandItemRegistryCollection {
    public static Item registerVoidLandSimpleItem(String path) {
        return registerVoidLandSimpleItem(path, new FabricItemSettings());
    }

    public static Item registerVoidLandSimpleItem(String path, FabricItemSettings settings) {
        return Registry.register(Registries.ITEM, new Identifier(voidland.namespace, path), new Item(settings));
    }

    public static Item registerVoidLandCustomItem(String path, Item custom) {
        return Registry.register(Registries.ITEM, new Identifier(voidland.namespace, path), custom);
    }
}
