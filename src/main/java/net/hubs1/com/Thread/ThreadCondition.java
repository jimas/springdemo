package net.hubs1.com.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCondition {
	
	
	public static void main(String[] args) {
		final Bussinus bussinus =new Bussinus();
		for (int i=0;i<10;i++) {
			new Thread(new Runnable(){
				public void run() {
					int nextInt = new Random().nextInt(100);
					bussinus.putValue(nextInt);
				}
			}).start();
			
		}
		for(int i=0;i<5;i++){
			new Thread(new Runnable(){
				public void run() {
					bussinus.getValue();
				}
			}).start();
			
		}
	}
	
	
	

}
class Bussinus{
	final int size=5;
	final Lock lock=new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty =lock.newCondition();
	List<String> listBlock=new ArrayList<String>(size);
	public void putValue(int val){
		try {
			lock.lock();
			while(listBlock.size()==size){
				notFull.await();
			}
			listBlock.add(val+"");
			System.out.println(Thread.currentThread().getName()+" add "+val);
			notEmpty.signal();
		} catch (Exception e) {
		
		}finally{
			lock.unlock();
		}
	}
	
	public void getValue(){
		try {
			lock.lock();
			while(listBlock.size()==0){
				notEmpty.await();
			}
			String string = listBlock.get(0);
			System.out.println(Thread.currentThread().getName()+" get "+string);
			notFull.signal();
		} catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}
	
}

/*class BoundedBuffer {
	   final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 

	   final Object[] items = new Object[100];
	   int putptr, takeptr, count;

	   public void put(Object x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length) 
	         notFull.await();
	       items[putptr] = x; 
	       if (++putptr == items.length) putptr = 0;
	       ++count;
	       notEmpty.signal();
	     } finally {
	       lock.unlock();
	     }
	   }

	   public Object take() throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == 0) 
	         notEmpty.await();
	       Object x = items[takeptr]; 
	       if (++takeptr == items.length) takeptr = 0;
	       --count;
	       notFull.signal();
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   } 
	 }*/
