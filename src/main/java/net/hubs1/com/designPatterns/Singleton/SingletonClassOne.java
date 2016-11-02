package net.hubs1.com.designPatterns.Singleton;
/**
 * 一个类有且仅有一个实例，并且自行实例化向整个系统提供
 * 
 * 单例模式
 * 
 * 第二种形式:饿汉式
 * @author weqinjia.liu
 * @Date 2016年7月22日
 */
public class SingletonClassOne {
	private static final  SingletonClassOne instance=new SingletonClassOne();
	
	//1.私有的构造函数
	private SingletonClassOne(){
		
	}
	
	public static  SingletonClassOne getInstance(){
		return instance;
	}

}
