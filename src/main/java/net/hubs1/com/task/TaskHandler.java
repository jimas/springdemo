package net.hubs1.com.task;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 任务调度 耗时统计
 * 模板方法模式
 * @author QinJia.Liu
 * @Date 2016年7月12日
 */
public abstract class TaskHandler {
	private static final Logger logger=Logger.getLogger(TaskHandler.class);
	
	public final  void execute(){
		Date startDate=new Date();
		String taskName=null;
		try {
			taskName=initTaskName();
			logger.info(taskName+" START ");
			run();
//			Thread.sleep(1000*5);//休眠5s
		} catch (Throwable e) {
			logger.error(taskName+" execute error",e);
		}finally{
			long ms = new Date().getTime()- startDate.getTime();
			long second = ms / 1000;
			logger.info("任务【"+taskName+"】 耗时:" + second / 3600 + "h" + (second / 60) % 60 + "m" + second % 60 + "s"+ms+"ms");
			
		}
	}

	/**
	 * 初始化<br>
	 * 设置任务名称<br>
	 */
	protected abstract String initTaskName();

	/**
	 * 执行任务
	 * @throws Throwable 
	 */
	public abstract void run() throws Throwable;


	
}
