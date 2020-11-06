
package net.mcreator.anomalyfoundationmod.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.DamageSource;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.anomalyfoundationmod.AnomalyFoundationModModElements;

@AnomalyFoundationModModElements.ModElement.Tag
public class DamageUpEnchantment extends AnomalyFoundationModModElements.ModElement {
	@ObjectHolder("anomaly_foundation_mod:damage_up")
	public static final Enchantment enchantment = null;
	public DamageUpEnchantment(AnomalyFoundationModModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("damage_up"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 78;
		}

		@Override
		public int calcModifierDamage(int level, DamageSource source) {
			return level * 2;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.SHARPNESS)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
