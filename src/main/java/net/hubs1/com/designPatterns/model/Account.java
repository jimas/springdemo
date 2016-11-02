package net.hubs1.com.designPatterns.model;

/**
 * 模板方法模式
 * 
 * @author weqinjia.liu
 * @Date 2016年8月9日
 */
public abstract class Account {

	/**
	 * 一般不允许 破化 模板的结构<br/>
	 * 故 该方法不许继承
	 * 
	 * @return
	 */
	public final double calculateInterest() {

		double interestRate = doCalculateInterestRate();
		String accountType = doCalculateAccountType();
		double amount = calculateAmount(accountType);
		return amount * interestRate;
	}
	/**
	 * 基本方法 自己已经实现
	 * @param accountType
	 * @return
	 */
	private double calculateAmount(String accountType) {
		
		return 1250;
	}
	/**
	 * 基本方法留给子类实现
	 * @return
	 */
	protected abstract String doCalculateAccountType();
	
	/**
	 * 基本方法留给子类实现
	 * @return
	 */
	protected abstract double doCalculateInterestRate() ;
}
