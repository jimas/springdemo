package net.hubs1.com.designPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubjectJimas implements SubjectJimas {
	//观察者列表
	private List<ObserverJimas> observers=new ArrayList<ObserverJimas>();
	//通知内容
	private String content;
	
	public synchronized void attech(ObserverJimas observer){
		if(!observers.contains(observer)){
			observers.add(observer);
		}
	}
	
	public synchronized void dettch(ObserverJimas observer){
		observers.remove(observer);
	}

	/**
	 * 通知观察者
	 */
	public void notifyObserver() {
		for (ObserverJimas observer : observers) {
			observer.update(this);
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		notifyObserver();
	}
	
	
}
