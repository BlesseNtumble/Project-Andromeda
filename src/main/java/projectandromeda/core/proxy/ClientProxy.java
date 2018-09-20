package projectandromeda.core.proxy;

import java.util.List;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import micdoodle8.mods.galacticraft.core.wrappers.ModelTransformWrapper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import projectandromeda.ProjectAndromeda;
import projectandromeda.core.events.PAClientEventsHandler;
import projectandromeda.core.registers.blocks.BasicE.EnumBasicE;
import projectandromeda.core.registers.blocks.PABlocks;

public class ClientProxy extends CommonProxy {

	@Override
    public void preload() {
		super.preload();
		this.register_event(new PAClientEventsHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@Override
    public void load() {
		super.load();
	}
	
	@Override
    public void postload() {
		super.postload();
	}
	
	@SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onModelBakeEvent(ModelBakeEvent event) {
		
    }
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void loadTextures(TextureStitchEvent.Pre event) {
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerRender() {
		super.registerRender();
		for(EnumBasicE val: EnumBasicE.values()) {
			ClientUtil.registerBlockJson(ProjectAndromeda.TEXTURE_PREFIX, PABlocks.e, val.getMeta(), val.getName());
		}
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerVariants() {
		super.registerVariants();
		ClientUtil.addVariant(ProjectAndromeda.MODID, "e", "e0", "e1", "e2");
    }
	
	public void registerTexture(Pre event, String texture) {
		event.getMap().registerSprite(new ResourceLocation(ProjectAndromeda.TEXTURE_PREFIX + texture));
	}
	
	private void replaceModelDefault(ModelBakeEvent event, String resLoc, String objLoc, List<String> visibleGroups, Class<? extends ModelTransformWrapper> clazz, IModelState parentState, String... variants) {
        ClientUtil.replaceModel(ProjectAndromeda.ASSET_PREFIX, event, resLoc, objLoc, visibleGroups, clazz, parentState, variants);
    }
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		ProjectAndromeda.proxy.registerVariants();
	}  
}
