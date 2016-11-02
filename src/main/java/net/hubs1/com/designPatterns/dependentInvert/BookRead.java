package net.hubs1.com.designPatterns.dependentInvert;

public class BookRead implements ReadInterface {

	public void read(String content) {
		System.out.println("开始读书->"+content);
	}

}
