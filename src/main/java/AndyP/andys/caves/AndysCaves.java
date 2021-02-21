package AndyP.andys.caves;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import AndyP.andys.caves.customBlocks.MOD_mushroom;

public class AndysCaves implements ModInitializer {

	//public static final Item GLOWING_MUSHROOM = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Block GLOWING_MUSHROOM_PLANT = new MOD_mushroom(FabricBlockSettings.of(Material.PLANT).noCollision()
	 														.breakInstantly().sounds(BlockSoundGroup.FUNGUS).nonOpaque()); 

	public static final Block MUSHROOM_BLOCK = new Block(FabricBlockSettings.of(Material.SOIL).strength(5.0f, 5.0f)
														 .sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.SHOVELS));


	// This code runs as soon as Minecraft is in a mod-load-ready state.
	// However, some things (like resources) may still be uninitialized.
	// Proceed with mild caution.
	@Override
	public void onInitialize() {
		

		// registry for item to appear in-game, in inventories etc
		Registry.register(Registry.BLOCK, new Identifier("andyscaves","glowing_mushroom"), GLOWING_MUSHROOM_PLANT);
		Registry.register(Registry.ITEM, new Identifier("andyscaves","glowing_mushroom"), 
						  new BlockItem(GLOWING_MUSHROOM_PLANT, new Item.Settings().group(ItemGroup.MISC)));
		BlockRenderLayerMap.INSTANCE.putBlock(AndysCaves.GLOWING_MUSHROOM_PLANT, RenderLayer.getCutout());
		
		// registry for block to be placeable in-game world
		// also requires registry for the item form
		Registry.register(Registry.BLOCK, new Identifier("andyscaves","mushroom_block"), MUSHROOM_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("andyscaves","mushroom_block"), 
						  new BlockItem(MUSHROOM_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
	}
}
