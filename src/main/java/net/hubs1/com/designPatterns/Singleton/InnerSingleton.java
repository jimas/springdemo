package net.hubs1.com.designPatterns.Singleton;
/**
 * @Description 匿名内部类实现 单例模式
 * @author weqinjia.liu
 * @Date 2017年5月15日
 */
public class InnerSingleton {
    
    //匿名内部类
    private static  class InnerSingletonClass{
        private static final InnerSingleton instance =new InnerSingleton();
    }

    //构造方法私有
    private InnerSingleton(){};
    
    //公用的获取唯一实例的方法
    public InnerSingleton getInstance(){
        return InnerSingletonClass.instance;
    }
     
}
