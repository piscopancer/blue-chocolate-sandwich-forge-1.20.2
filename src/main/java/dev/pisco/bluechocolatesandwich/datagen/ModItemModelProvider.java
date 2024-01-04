package dev.pisco.bluechocolatesandwich.datagen;

import dev.pisco.bluechocolatesandwich.BlueChocolateSandwich;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemModelProvider extends ItemModelProvider {
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, BlueChocolateSandwich.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		registerItemModel(BlueChocolateSandwich.BLUE_CHOCOLATE_SANDWICH_ITEM);
	}

	ItemModelBuilder registerItemModel(RegistryObject<Item> item) {
		final String itemPath = item.getId().getPath();
		return withExistingParent(itemPath, "item/generated").texture("layer0",
			new ResourceLocation(BlueChocolateSandwich.MOD_ID, "item/" + itemPath));
	}

}
