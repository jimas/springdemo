package net.hubs1.com.designPatterns.Chain.handle;


public class CEO extends PriceHandle {

	@Override
	public void dealDiscount(float discount) {
		if(discount<0.5){
			System.out.format("%s处理了这个折扣,折扣为%.2f%n",this.getClass().getName(),discount);
		}else{
			System.out.format("%s否决了这个折扣,折扣为%.2f%n",this.getClass().getName(),discount);
		}	
		
	}

}
