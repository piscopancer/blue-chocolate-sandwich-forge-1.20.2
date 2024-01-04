package dev.pisco.bluechocolatesandwich;

import dev.pisco.bluechocolatesandwich.item.BlueChocolateSandwichItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(BlueChocolateSandwich.MOD_ID)
public class BlueChocolateSandwich {
	public static final String MOD_ID = "bluechocolatesandwich";

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
	public static final RegistryObject<Item> BLUE_CHOCOLATE_SANDWICH_ITEM = ITEMS.register("blue_chocolate_sandwich",
		() -> new BlueChocolateSandwichItem());

	public BlueChocolateSandwich() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(modEventBus);
		ModCreativeModeTab.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::addCreative);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
			event.accept(BLUE_CHOCOLATE_SANDWICH_ITEM);
	}

	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {

	}
}
