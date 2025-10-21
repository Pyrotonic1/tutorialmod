package org.cibermo.tutorialmod.item;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.cibermo.tutorialmod.Tutorialmod;
import net.minecraft.registry.Registries;

import java.util.function.Function;

public class ModItems implements ModInitializer {

    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Tutorialmod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
        }

        public static final Item PINK_GARNET = register("item.tutorialmod.pink_garnet", Item::new, new Item.Settings());

        public static void initialize() {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                    .register((itemGroup) -> itemGroup.add(ModItems.PINK_GARNET));
        }

        }




