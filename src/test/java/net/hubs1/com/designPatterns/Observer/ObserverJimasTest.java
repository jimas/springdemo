package net.hubs1.com.designPatterns.Observer;

import org.junit.Test;

public class ObserverJimasTest {

	
	@Test
	public void test() {
		//1.目标
		WeatherSubjectJimas subject=new WeatherSubjectJimas();
		//观察者
		WeatherObserverJimas observerA=new WeatherObserverJimas("Observer-A");
		WeatherObserverJimas observerB=new WeatherObserverJimas("Observer-B");
		//目标注册观察者
		subject.attech(observerA);
		subject.attech(observerB);
		//设置通知的内容
		subject.setContent("明天天气晴朗、多云。");
		
//		subject.notifyObserver();
		
	}
	@Test
	public void testObserver() {
		WeatherSubject subject=new WeatherSubject();
		WeatherObserver observerA=new WeatherObserver("Observer-A");
		WeatherObserver observerB=new WeatherObserver("Observer-B");
		subject.addObserver(observerA);
		subject.addObserver(observerB);
		subject.setContent("ninhao");
		
	}

}
