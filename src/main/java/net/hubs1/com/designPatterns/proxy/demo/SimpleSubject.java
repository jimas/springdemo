package net.hubs1.com.designPatterns.proxy.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * SimpleSubject 
 *  
 * @author Kevin Fan 
 * @since 2013-9-13 下午2:45:03 
 */  
public class SimpleSubject implements Subject {  
    private Map<String, String> msg = new ConcurrentHashMap<String, String>();  
  
    public void pub(String key, String content) {  
        System.out.println("pub msg: key is " + key + ", content is " + content);  
        msg.put(key, content);  
    }  
  
    public String sub(String key) {  
        if (msg.containsKey(key)) {  
            String ret = msg.get(key);  
            System.out.println("sub msg: key is " + key + ", result is " + ret);  
            return ret;  
        }  
  
        return null;  
    }  
  
}  