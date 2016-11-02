// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package net.hubs1.com.designPatterns.proxy;

import java.lang.reflect.*;
import net.hubs1.com.designPatterns.proxy.Moveable;

/**
 * 生成的动态代理类
 * @author weqinjia.liu
 * @Date 2016年8月12日
 */
public final class $Proxy0 extends Proxy implements Moveable{

	private static final long serialVersionUID = -4567343552798444577L;
	private static Method m1;
	private static Method m3;
	private static Method m2;
	private static Method m0;

	public $Proxy0(InvocationHandler invocationhandler)
	{
		super(invocationhandler);
	}

	public final boolean equals(Object obj)
	{
		try
		{
			return ((Boolean)super.h.invoke(this, m1, new Object[] {
				obj
			})).booleanValue();
		}
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final void move()
	{
		try
		{
			super.h.invoke(this, m3, null);
			return;
		}
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final String toString()
	{
		try
		{
			return (String)super.h.invoke(this, m2, null);
		}
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final int hashCode()
	{
		try
		{
			return ((Integer)super.h.invoke(this, m0, null)).intValue();
		}
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	static 
	{
		try
		{
			m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] {
				Class.forName("java.lang.Object")
			});
			m3 = Class.forName("net.hubs1.com.designPatterns.proxy.Moveable").getMethod("move", new Class[0]);
			m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
			m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
		}
		catch (NoSuchMethodException nosuchmethodexception)
		{
			throw new NoSuchMethodError(nosuchmethodexception.getMessage());
		}
		catch (ClassNotFoundException classnotfoundexception)
		{
			throw new NoClassDefFoundError(classnotfoundexception.getMessage());
		}
	}
}
