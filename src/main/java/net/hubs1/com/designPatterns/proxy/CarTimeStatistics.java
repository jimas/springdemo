package net.hubs1.com.designPatterns.proxy;
/**
 * 静态代理
 * @author weqinjia.liu
 * @Date 2016年7月26日
 */
public class CarTimeStatistics extends Car {
	
	@Override
	public void move() {
		System.out.println("start statistics time ");
		super.move();
		System.out.println("statistics time end");
	}

}
