package net.hubs1.com.designPatterns.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	private Enhancer enhancer=new Enhancer();
	public Object getProxy(@SuppressWarnings("rawtypes") Class clazz){
		//设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		//通过字节码技术动态创建子类对象
		return enhancer.create();
	}
	//实现MethodInterceptor 接口方法
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("前置代理");
		Object result = proxy.invokeSuper(target, args);
		System.out.println("后置代理");
		return result;
	}

	
	/**
	 * main 测试类
	 * @param args
	 */
	public static void main(String[] args) {
		//设置此系统属性,以查看代理类文件  
		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
		CglibProxy proxy=new CglibProxy();
		System.out.println(proxy.getProxy(SayHello.class));
		SayHello sayHello = (SayHello)proxy.getProxy(SayHello.class);
		sayHello.say();
		System.out.println(sayHello.getClass().getSimpleName());
		System.out.println(sayHello.getClass().getPackage());
		System.out.println(sayHello.getClass().getProtectionDomain());
	}
}
