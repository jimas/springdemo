package net.hubs1.com.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * java.util.ConcurrentModificationException
 * @descritube 对集合进行遍历时  不能改变集合的大小
 * @author weqinjia.liu
 * @Date 2016年7月18日
 */
public class Collection1 {
	public static void main(String[] args) {
		
//		List<String> list=new ArrayList<String>();
		Collection<String> list = new CopyOnWriteArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String next = it.next();
			if(next.equals("aa")){
				list.remove(next);
			}else{
				System.out.println(next);
			}
		}
		
	}
}
