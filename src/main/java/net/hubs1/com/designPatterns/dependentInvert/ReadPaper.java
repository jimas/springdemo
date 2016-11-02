package net.hubs1.com.designPatterns.dependentInvert;

public class ReadPaper implements ReadInterface {

	public void read(String content) {
		System.out.println("开始读报纸->"+content);

	}

}
