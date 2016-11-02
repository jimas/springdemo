package net.hubs1.com.designPatterns.Observer;


public class WeatherObserverJimas implements ObserverJimas {
	//观察者名称
    private String observerName;
    
    public WeatherObserverJimas(String observerName){
    	this.observerName=observerName;
    }

	public void update(SubjectJimas subject) {
		System.out.println("通知的观察者->"+observerName+",通知的内容："+((WeatherSubjectJimas)subject).getContent());
	}
}
