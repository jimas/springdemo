package net.hubs1.com.designPatterns.proxy.demo;
/** 
 * Subject 
 *  
 * @author Kevin Fan 
 * @since 2013-9-13 下午2:43:33 
 */  
public interface Subject {  
    void pub(String key, String content);  
  
    String sub(String key);  
} 