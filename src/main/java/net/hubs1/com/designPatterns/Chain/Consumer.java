package net.hubs1.com.designPatterns.Chain;

import java.util.Random;

import net.hubs1.com.designPatterns.Chain.handle.PriceHandle;

public class Consumer {

	/**
	 * 客户提出折扣申请
	 * @param disponse
	 */
	public void proposeDisponse(float discount){
		
		PriceHandle priceHandle = PriceHandleFactory.createPriceHandleInstance();
		priceHandle.dealDiscount(discount);
	}
	
	
	
	public static void main(String[] args) {
		Consumer consumer = new Consumer();
		for (int i = 0; i <=100; i++) {
			consumer.proposeDisponse(new Random().nextFloat());
		}
	}

}
