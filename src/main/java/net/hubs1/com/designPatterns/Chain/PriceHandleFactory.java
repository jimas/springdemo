package net.hubs1.com.designPatterns.Chain;

import net.hubs1.com.designPatterns.Chain.handle.CEO;
import net.hubs1.com.designPatterns.Chain.handle.Lead;
import net.hubs1.com.designPatterns.Chain.handle.Manager;
import net.hubs1.com.designPatterns.Chain.handle.PriceHandle;
import net.hubs1.com.designPatterns.Chain.handle.Sales;
import net.hubs1.com.designPatterns.Chain.handle.VicePresident;

/**
 * 设计直接后继
 * @author weqinjia.liu
 * @Date 2016年8月5日
 */
public class PriceHandleFactory {
	
	public static PriceHandle createPriceHandleInstance(){
		PriceHandle sales=new Sales();
		PriceHandle lead=new Lead();
		PriceHandle manager=new Manager();
		PriceHandle vp=new VicePresident();
		PriceHandle ceo=new CEO();
		
		sales.setSuccessor(lead);
		lead.setSuccessor(manager);
		manager.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		return sales;
	}

}
