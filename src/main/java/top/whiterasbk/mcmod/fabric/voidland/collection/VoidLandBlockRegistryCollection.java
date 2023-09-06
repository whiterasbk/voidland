package top.whiterasbk.mcmod.fabric.voidland.collection;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import top.whiterasbk.mcmod.fabric.voidland.voidland;

public abstract class VoidLandBlockRegistryCollection {
    public static Block registerVoidLandSimpleBlock(String path) {
        return registerVoidLandSimpleBlock(path, FabricBlockSettings.create().strength(4.0f));
    }

    public static Block registerVoidLandSimpleBlock(String path, FabricBlockSettings settings) {
        var block = Registry.register(Registries.BLOCK, new Identifier(voidland.namespace, path),
                new Block(settings));
        Registry.register(Registries.ITEM, new Identifier(voidland.namespace, path),
                new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerVoidLandCustomBlock(String path, Block custom) {
        var block = Registry.register(Registries.BLOCK, new Identifier(voidland.namespace, path),
                custom);
        Registry.register(Registries.ITEM, new Identifier(voidland.namespace, path),
                new BlockItem(block, new FabricItemSettings()));
        return block;
    }
}
