package dev.pisco.bluechocolatesandwich.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class BlueChocolateSandwichItem extends Item {
	public static final Item.Properties PROPERTIES = new Item.Properties().durability(4)
		.food(new FoodProperties.Builder().fast().nutrition(1).saturationMod(0.5f).build());

	public BlueChocolateSandwichItem() {
		super(PROPERTIES);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(e.getUsedItemHand()));
		super.finishUsingItem(stack.copy(), level, entity);
		return stack;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
		super.appendHoverText(stack, level, components, flag);
		components.add(Component.translatable("tooltip.item.blue_chocolate_sandwich.tooltip").withStyle(ChatFormatting.AQUA,
			ChatFormatting.ITALIC));
	}
}
