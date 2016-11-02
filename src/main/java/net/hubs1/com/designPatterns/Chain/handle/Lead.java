package net.hubs1.com.designPatterns.Chain.handle;


public class Lead extends PriceHandle {

	@Override
	public void dealDiscount(float discount) {
		if(discount<0.15){
			System.out.format("%s处理了这个折扣,折扣为%.2f%n",this.getClass().getName(),discount);
		}else{
			successor.dealDiscount(discount);
		}	
		
	}

}
