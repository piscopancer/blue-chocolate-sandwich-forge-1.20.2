package dev.pisco.bluechocolatesandwich;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
		.create(Registries.CREATIVE_MODE_TAB, BlueChocolateSandwich.MOD_ID);
	public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register(
		String.format("%s_tab", BlueChocolateSandwich.MOD_ID),
		() -> CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.COMBAT)
			.icon(() -> BlueChocolateSandwich.BLUE_CHOCOLATE_SANDWICH_ITEM.get().getDefaultInstance())
			.title(Component.translatable("creativetab.blue_chocolate_sandwich_tab")).displayItems((parameters, output) -> {
				output.accept(BlueChocolateSandwich.BLUE_CHOCOLATE_SANDWICH_ITEM.get());
			}).build());

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}
