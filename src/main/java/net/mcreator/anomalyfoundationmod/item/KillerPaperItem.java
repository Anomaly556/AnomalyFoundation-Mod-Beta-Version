
package net.mcreator.anomalyfoundationmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.anomalyfoundationmod.procedures.KillerPaperRightClickedInAirProcedure;
import net.mcreator.anomalyfoundationmod.itemgroup.AnomlItemGroup;
import net.mcreator.anomalyfoundationmod.AnomalyFoundationModModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@AnomalyFoundationModModElements.ModElement.Tag
public class KillerPaperItem extends AnomalyFoundationModModElements.ModElement {
	@ObjectHolder("anomaly_foundation_mod:killer_paper")
	public static final Item block = null;
	public KillerPaperItem(AnomalyFoundationModModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AnomlItemGroup.tab).maxStackSize(64));
			setRegistryName("killer_paper");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("The paper was killing you!"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				KillerPaperRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
