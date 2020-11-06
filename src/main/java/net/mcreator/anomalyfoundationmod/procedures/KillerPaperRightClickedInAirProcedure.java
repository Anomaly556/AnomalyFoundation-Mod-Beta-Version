package net.mcreator.anomalyfoundationmod.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.anomalyfoundationmod.AnomalyFoundationModModElements;

import java.util.Map;

@AnomalyFoundationModModElements.ModElement.Tag
public class KillerPaperRightClickedInAirProcedure extends AnomalyFoundationModModElements.ModElement {
	public KillerPaperRightClickedInAirProcedure(AnomalyFoundationModModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KillerPaperRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) 0);
	}
}
