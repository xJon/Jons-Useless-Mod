package xjon.jum.network;

import com.sun.org.apache.xml.internal.security.encryption.Reference;
import com.sun.org.apache.xml.internal.security.signature.reference.ReferenceSubTreeData;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	
	 private static SimpleNetworkWrapper INSTANCE;

	public static void init(){
		
	        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(xjon.jum.util.Reference.MOD_ID);
	      
	        INSTANCE.registerMessage(MessageTeleport.class, MessageTeleport.class, 0, Side.SERVER);
	}
	
	public static void sendToServer(IMessage message){
        INSTANCE.sendToServer(message);
    }	
	 

}
