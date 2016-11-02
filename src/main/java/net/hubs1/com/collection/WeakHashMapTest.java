package net.hubs1.com.collection;  
  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.WeakHashMap;  
 
/**
 * WeakHashMap实现了Map接口，是HashMap的一种实现，他使用弱引用作为内部数据的存储方案，
 * WeakHashMap可以作为简单缓存表的解决方案，
 * 当系统内存不够的时候，垃圾收集器会自动的清除没有在其他任何地方被引用的键值对
 * @author weqinjia.liu
 * @Date 2016年8月12日
 */
public class WeakHashMapTest {  
    public static void main(String[] args) throws Exception {  
        String a = new String("a");  
        String b = new String("b");  
        Map weakmap = new WeakHashMap();  
        Map map = new HashMap();  
        map.put(a, "aaa");  
        map.put(b, "bbb");  
  
          
        weakmap.put(a, "aaa");  
        weakmap.put(b, "bbb");  
          
        map.remove(a);  
          
        a=null;  
        b=null;  
          
        System.gc();  
        Iterator i = map.entrySet().iterator();  
        while (i.hasNext()) {  
            Map.Entry en = (Map.Entry)i.next();  
            System.out.println("map:"+en.getKey()+":"+en.getValue());  
        }  
  
        Iterator j = weakmap.entrySet().iterator();  
        while (j.hasNext()) {  
            Map.Entry en = (Map.Entry)j.next();  
            System.out.println("weakmap:"+en.getKey()+":"+en.getValue());  
              
        }  
    }  
  
      
}  