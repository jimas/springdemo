package net.hubs1.com.designPatterns.Singleton;
/**
 * 一个类有且仅有一个实例，并且自行实例化向整个系统提供
 * 
 * 单例模式
 * 
 * 第三种形式: 双重锁的形式。
 * @author weqinjia.liu
 * @Date 2016年7月22日
 */
public class SingletonClassTwo {
	
	private static  SingletonClassTwo instance=null;
	
	//1.私有的构造函数
	private SingletonClassTwo(){
		
	}
	
	public static  SingletonClassTwo getInstance(){
		if(instance==null){
			synchronized (SingletonClassTwo.class) {
				instance=new SingletonClassTwo();
			}
			
		}
		
		return instance;
	}

}
