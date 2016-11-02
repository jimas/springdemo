package net.hubs1.com.designPatterns.proxy;

import java.lang.reflect.Proxy;

public class JDKProxyTest {

	public static void main(String[] args) {
		//设置此系统属性,以查看代理类文件  
		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
		
		
		Car target=new Car();
		JDKProxy proxp=new JDKProxy(target);
		Moveable moveable = (Moveable) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxp);
		System.out.println(moveable.getClass());

		moveable.move();
	}

}
