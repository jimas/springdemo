package net.hubs1.com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 注解
 * @author weqinjia.liu
 * @Date 2016年7月25日
 */
@Jimas(color="blue",value=213)//不能省略 value=
public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		AnnotationTest test=new AnnotationTest();
		Class<? extends AnnotationTest> class1 = test.getClass();
		boolean annotationPresent = class1.isAnnotationPresent(Jimas.class);//是否存在Jimas 注解
		if(annotationPresent){
			Annotation[] declaredAnnotations = class1.getDeclaredAnnotations();
			for (Annotation annotation : declaredAnnotations) {
				System.out.println(annotation);
			}
			Jimas annotation = class1.getAnnotation(Jimas.class);
			System.out.println(annotation);
			System.out.println(annotation.color());
			System.out.println(annotation.value());
		}
		
		Method method = class1.getMethod("testAnnot", null);
		boolean annotationPresent2 = method.isAnnotationPresent(Jimas.class);
		if(annotationPresent2){
			Jimas declaredAnnotation = method.getDeclaredAnnotation(Jimas.class);
			System.out.println(declaredAnnotation);
			System.out.println(declaredAnnotation.color());
			System.out.println(declaredAnnotation.value());
		}
	}
	
	@Jimas(23)//注解 属性名为value 时 并且 只需为value 赋值时 可以省略 value=
	public String testAnnot(){
		return "jack";
	}
}
