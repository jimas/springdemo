package net.hubs1.com.designPatterns.Chain.handle;

/**
 * 责任链模式
 * @author weqinjia.liu
 * @Date 2016年8月5日
 */
public abstract class PriceHandle {
	//责任链 后继
	public PriceHandle successor;

	public void setSuccessor(PriceHandle successor) {
		this.successor = successor;
	}
	
	public abstract void dealDiscount(float discount);

}
