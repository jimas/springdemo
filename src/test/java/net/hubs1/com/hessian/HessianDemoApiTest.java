package net.hubs1.com.hessian;

import java.io.IOException;

import net.hubs1.com.BaseTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caucho.hessian.client.HessianProxyFactory;

public class HessianDemoApiTest extends BaseTest{

	@Autowired
	private HessianDemoServiceOne serviceOne;
	@Autowired
	private HessianDemoServiceTwo serviceTwo;
	@Test
	public void testSayhello() throws IOException {
		String url="http://127.0.0.1:8090/SpringDemo/remote/HessianDemoApiTwo";
		HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
		System.out.println(hessianProxyFactory.create(HessianDemoApi.class, url));
		HessianDemoApi one =(HessianDemoApi)hessianProxyFactory.create(HessianDemoApi.class, url);
		
		System.out.println(one.sayhello("one"));
	}

}
