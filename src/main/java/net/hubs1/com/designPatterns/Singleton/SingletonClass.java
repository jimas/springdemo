package net.hubs1.com.designPatterns.Singleton;
/**
 * 一个类有且仅有一个实例，并且自行实例化向整个系统提供
 * 
 * 单例模式
 * 
 * 第一种形式:懒汉式，也是常用的形式
 * @author weqinjia.liu
 * @Date 2016年7月22日
 */
public class SingletonClass {
	private static SingletonClass instance=null;
	
	//1.私有的构造函数
	private SingletonClass(){
		
	}
	
	public static synchronized SingletonClass getInstance(){
		if(instance==null){
			instance=new SingletonClass();
		}
		return instance;
	}

}
