package dev.pisco.bluechocolatesandwich.datagen;

import dev.pisco.bluechocolatesandwich.BlueChocolateSandwich;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(PackOutput output) {
		super(output);
	}

	@Override
	protected void buildRecipes(RecipeOutput output) {
		twoByTwoPacker(output, RecipeCategory.FOOD, BlueChocolateSandwich.BLUE_CHOCOLATE_SANDWICH_ITEM.get(), Items.COOKIE);
	}

}
