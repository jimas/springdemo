package net.hubs1.com.designPatterns.Observer;

import java.util.Observable;

public class WeatherSubject extends Observable {
	//通知内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		this.setChanged();//这个必须设置
		this.notifyObservers();
	}
	
}
