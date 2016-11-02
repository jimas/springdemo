package net.hubs1.com.hessian;

import org.springframework.stereotype.Service;

@Service
public class HessianDemoServiceTwo implements HessianDemoApi {

	public String sayhello(String message) {
		
		return "HessianDemoServiceTwo->"+message;
	}

}
