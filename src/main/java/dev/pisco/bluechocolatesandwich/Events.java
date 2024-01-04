package dev.pisco.bluechocolatesandwich;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;

@Mod.EventBusSubscriber(modid = BlueChocolateSandwich.MOD_ID)
public class Events {

	@SubscribeEvent
	public static void subscribeBlockEvent(BlockEvent.BreakEvent breakEvent) {
		final var chance = Math.floor(Math.random() * 10) / 10.0;
		if (chance > 0.5) {
			breakEvent.getPlayer().getInventory()
				.add(new ItemStack(BlueChocolateSandwich.BLUE_CHOCOLATE_SANDWICH_ITEM.get(), 1));
		} else {
			breakEvent.getPlayer().sendSystemMessage(Component.literal("Good luck bro: ")
				.append(Component.literal(String.valueOf(chance)).withStyle(ChatFormatting.AQUA, ChatFormatting.ITALIC)));
		}
	}
}
