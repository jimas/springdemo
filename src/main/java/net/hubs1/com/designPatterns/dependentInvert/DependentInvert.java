package net.hubs1.com.designPatterns.dependentInvert;


/**
 * @deprecated依赖倒置原则
 * 抽象不应该依赖于细节。细节应该依赖于抽象。程序中所有的依赖关系都应该终止于抽象类和接口。
 * 针对接口而非实现编程。任何变量都不应该持有一个指向具体类的指针或引用。任何类都不应该从具体类派生。
 * 任何方法都不应该覆写他的任何基类中的已经实现了的方法
 * @author weqinjia.liu
 * @Date 2016年7月22日
 */
public class DependentInvert {
	public static void main(String[] args) {
		DependentInvert depend=new DependentInvert();
		depend.readMothod(new BookRead());
		depend.readMothod(new ReadPaper());
	}
	
	public void readMothod(ReadInterface readIte){
		readIte.read("从前有一个故事。。。。");
	}
}
