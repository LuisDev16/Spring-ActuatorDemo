package com.BryanDev.Actuator.api.health;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthMetrics implements HealthIndicator{

	@Override
	public Health health() {
		
	Health health=checkInternet()==true?Health.up().withDetail("success code", "Active Internet Connection").build()
				:Health.down().withDetail("error code", "Inactive Internet Connection").build();
		return health;
	}
	
	private boolean checkInternet() {
		boolean flag=false;
		try {
			URL url=new URL("https://www.instagram.com");
			URLConnection connection=url.openConnection();
			connection.connect();
			flag=true;		
		} catch(Exception e) {
			flag=false;
		}
		return flag;
	}

}
