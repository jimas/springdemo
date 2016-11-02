package net.hubs1.com.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 动态代理
 * @author weqinjia.liu
 * @Date 2016年7月26日
 */
public class JDKProxy implements InvocationHandler{
	
	private Object target = null; 
	
	
	public JDKProxy(Object target) {
		super();
		this.target = target;
	}


	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		System.out.println("start statistics time ");
		Object obj = method.invoke(target, args);
		System.out.println("statistics time end");
		return obj;
	}

}
