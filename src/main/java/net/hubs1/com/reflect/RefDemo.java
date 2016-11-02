package net.hubs1.com.reflect;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Java中getResourceAsStream的用法

首先，Java中的getResourceAsStream有以下几种： 
1. Class.getResourceAsStream(String path) ： path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从

ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。

2. Class.getClassLoader.getResourceAsStream(String path) ：默认则是从ClassPath根下获取，path不能以’/'开头，最终是由

ClassLoader获取资源。
 * @author weqinjia.liu
 * @Date 2016年7月25日
 */
public class RefDemo {
	
	public static void main(String[] args) throws Exception{
		String fileName="readme.properties";
		InputStream resourceAsStream = RefDemo.class.getClassLoader().getResourceAsStream("net/hubs1/com/reflect/"+fileName);
//		InputStream file = RefDemo.class.getResourceAsStream(fileName);
//		InputStream index = RefDemo.class.getResourceAsStream("WEB-INF/index.properties");
		
		System.out.println(resourceAsStream);
//		System.out.println(file);
//		System.out.println(index);		
		Properties p = new Properties();  
		p.load(resourceAsStream);
		Object object = p.get("className");
		System.out.println(object);
		Class<?> forName = Class.forName(object.toString());
		//创建此 Class 对象所表示的类的一个新实例  默认是无参数的构造函数
		Object person = forName.newInstance();
		System.out.println(person);
		
		Object invoke = forName.getMethod("setName", String.class).invoke(person, "jimas");
		forName.getMethod("setAge", Integer.class).invoke(person, 12);
		System.out.println(invoke);
		//创建此 Class 对象所表示的类的一个新实例 有参数
		Constructor<?> constructor = forName.getConstructor(String.class,Integer.class);
		Object person2 = constructor.newInstance("jack",23);
//		forName.
		Field[] fields = forName.getDeclaredFields();//所有声明的字段  getFields() 所有可访问公共字段。
		for (Field field : fields) {
			field.setAccessible(true);//设置可以访问
			System.out.println(field.getName()+":"+field.get(person));
			System.out.println(field.getName()+":"+field.get(person2));
		}
		
		PropertyDescriptor pdt=new PropertyDescriptor("name", forName);
		System.out.println(pdt.getReadMethod());//get
		System.out.println(pdt.getWriteMethod());//set
		pdt.setValue("age", 23);
		System.out.println(pdt.getValue("age"));
		pdt.getWriteMethod().invoke(person2, "tom");
		System.out.println(pdt.getReadMethod().invoke(person2));
	}

}
