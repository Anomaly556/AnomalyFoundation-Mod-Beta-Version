
package net.mcreator.anomalyfoundationmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.anomalyfoundationmod.item.AML811stoolItem;
import net.mcreator.anomalyfoundationmod.AnomalyFoundationModModElements;

@AnomalyFoundationModModElements.ModElement.Tag
public class AnomlItemGroup extends AnomalyFoundationModModElements.ModElement {
	public AnomlItemGroup(AnomalyFoundationModModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanoml") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AML811stoolItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
