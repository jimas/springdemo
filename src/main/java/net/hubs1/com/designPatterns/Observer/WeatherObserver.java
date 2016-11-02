package net.hubs1.com.designPatterns.Observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherObserver implements Observer {

	//观察者名称
	private String observerName;
	public WeatherObserver(String observerName) {
		this.observerName = observerName;
	}
	public void update(Observable o, Object arg) {
		System.out.println("通知的观察者->"+observerName+",通知的内容："+((WeatherSubject)o).getContent());
	}

	
}
