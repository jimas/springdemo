package net.hubs1.com.task;

import org.springframework.stereotype.Service;

import net.hubs1.com.file.ReadFromFile;
@Service("threadReadFileTask")
public class ThreadReadFileTask extends TaskHandler{

	private static long filePointerPosition=0;
	public void run() {
		System.out.println("ThreadReadFileTask execute !");
		String fileName="D:\\home\\app\\logs\\SpringDemo/springDemo.log";
		long beginIndex=filePointerPosition;
		filePointerPosition = ReadFromFile.readFileByRandomAccess(fileName, beginIndex);
	}

	@Override
	protected String initTaskName() {
		return "ThreadReadFileTask";
	}

}
