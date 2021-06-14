package agency.highlysuspect.halogen.item;

import agency.highlysuspect.halogen.Init;
import agency.highlysuspect.halogen.aura.AuraType;
import agency.highlysuspect.halogen.block.HaloBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class HaloItems {
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(Init.id("group"), HaloItems::icon);
	
	public static final BlockItem BASIC_NODE = blockItem(HaloBlocks.BASIC_NODE);
	public static final AuraCrystalItem WHITE_AURA_CRYSTAL = reg("white_aura_crystal", new AuraCrystalItem(AuraType.WHITE.stack(10), settings()));
	public static final LinkingWandItem LINKING_WAND = reg("linking_wand", new LinkingWandItem(settings().maxCount(1)));
	
	private static BlockItem blockItem(Block b) {
		return Registry.register(Registry.ITEM, Registry.BLOCK.getId(b), new BlockItem(b, settings()));
	}
	
	private static <I extends Item> I reg(String idPath, I i) {
		return Registry.register(Registry.ITEM, Init.id(idPath), i);
	}
	
	private static Item.Settings settings() {
		return new Item.Settings().group(GROUP);
	}
	
	private static ItemStack icon() {
		return new ItemStack(BASIC_NODE);
	}
	
	public static void onInitialize() {
		//Classload
	}
}