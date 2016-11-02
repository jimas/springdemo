package net.hubs1.com.collection;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {
	final static  Bussines Bussines=new Bussines();
	public static void main(String[] args) {
		for (int i=0;i<10;i++) {
			new Thread(new Runnable(){
				public void run() {
					Bussines.add();
				}
			}).start();
		}
		
		for (int i=0;i<6;i++) {
			new Thread(new Runnable(){
				public void run() {
					Bussines.take();
				}
			}).start();
		}
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static class Bussines{
		ArrayBlockingQueue<String> Queue = new ArrayBlockingQueue<String>(4);
		public void add(){
			try {
				Thread.sleep(1000);
				int nextInt = new Random().nextInt(10);
				Queue.put(""+nextInt);
				System.out.println("put "+nextInt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void take(){
			try {
				Thread.sleep(1000);
				String take = Queue.take();
				System.out.println("take "+take);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
