package net.hubs1.com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * RetentionPolicy.RUNTIME  内存中有效
 * RetentionPolicy.SOURCE, 源文件有效
 * RetentionPolicy.CLASS 字节码文件 有效
 * @author weqinjia.liu
 * @Date 2016年7月25日
 */
@Target(value={ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Jimas {
	String color() default "red";
	int value();
}
