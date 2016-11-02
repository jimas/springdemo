package net.hubs1.com.designPatterns.proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * SubjectProxyFactory 
 *  
 * @author Kevin Fan 
 * @since 2013-9-13 下午2:47:24 
 */  
public class SubjectProxyFactory {  
    //TODO: cache   
    public static Subject getSubject(final Subject realSubject) {  
        return (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), new Class[] { Subject.class },  
                new InvocationHandler() {  
  
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
                        System.out.println("\naction before method invocation....");  
                        Object retVal = method.invoke(realSubject, args);  
                        System.out.println("action after method invocation....\n");  
                        return retVal;  
                    }  
                });  
    }  
} 