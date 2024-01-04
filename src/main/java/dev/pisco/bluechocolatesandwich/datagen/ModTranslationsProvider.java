package dev.pisco.bluechocolatesandwich.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModTranslationsProvider extends LanguageProvider {

	public ModTranslationsProvider(PackOutput output, String modid, String locale) {
		super(output, modid, locale);
	}

	@Override
	protected void addTranslations() {
	}

}
