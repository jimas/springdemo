package net.hubs1.com.designPatterns.proxy.demo;
/** 
 * Demo 
 *  
 * @author Kevin Fan 
 * @since 2013-9-13 下午2:50:28 
 */  
public class Demo {  
    public static void main(String[] args) {  
        //设置此系统属性,以查看代理类文件  
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  
          
        //创建真实对象  
        Subject subj = new SimpleSubject();  
        subj.pub("name", "kevin.fan");  
        subj.sub("name");  
          
        //创建代理对象  
        Subject proxy = SubjectProxyFactory.getSubject(subj);  
        proxy.pub("hobby", "r&b music");  
        proxy.sub("name");  
    }  
} 