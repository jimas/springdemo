package net.hubs1.com.task;

import org.springframework.stereotype.Service;

import net.hubs1.com.file.ReadFromFile;
@Service("threadBufferReadFileTask")
public class ThreadBufferReadFileTask extends TaskHandler{

	private static long bufferFilePointerPosition=0;
	public void run() {
		System.out.println("ThreadReadFileTask execute !");
		String fileName="D:\\home\\app\\logs\\SpringDemo/springDemo.log";
		long bufferBeginIndex=bufferFilePointerPosition;
		bufferFilePointerPosition = ReadFromFile.readFileByBufferedRandomAccess(fileName, bufferBeginIndex);
	}

	@Override
	protected String initTaskName() {
		return "ThreadBufferReadFileTask";
	}

}
