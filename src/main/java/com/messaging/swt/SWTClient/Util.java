package com.messaging.swt.SWTClient;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;

public final class Util {
	
	private static WebTarget getWebTarget() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget 
		  = client.target("http://ibmmqcloud.herokuapp.com/api/messaging/v1");
		
		return webTarget;
	}

	public static Builder getInvocationBuilder() {
		return getWebTarget().request(MediaType.APPLICATION_JSON);
	}
	
	public static String toString(Date dat) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return format.format(dat);
	}
}
