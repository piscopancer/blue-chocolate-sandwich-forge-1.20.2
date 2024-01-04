package dev.pisco.bluechocolatesandwich.datagen;

import dev.pisco.bluechocolatesandwich.BlueChocolateSandwich;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlueChocolateSandwich.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		var generator = event.getGenerator();
		var packOutput = generator.getPackOutput();

		generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, event.getExistingFileHelper()));
		generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
	}
}
