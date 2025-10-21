package org.cibermo.tutorialmod.item;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.cibermo.tutorialmod.Tutorialmod;
import net.minecraft.registry.Registries;
public class ModItems implements ModInitializer {
    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(Tutorialmod.MOD_ID,id);

        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
        }
        public static final Item PINK_GARNET = register(
                new Item(new Item.Settings()),
        "pink_garnet"
        );
        public static void initialize() {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                    .register((itemGroup) -> itemGroup.add(ModItems.PINK_GARNET));
        }

        }




