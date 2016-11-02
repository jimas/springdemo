package net.hubs1.com.file;
import java.io.IOException;  
import java.io.RandomAccessFile;  
  
/** 
 * RandomAccessFile是属于随机读取类，是可以对文件本身的内容直接随机进行操作的，就是说可以指定位置 
 * 的读取和写入内容 
 * @author andy 
 * 
 */  
public class RandomAccessFileTest {  
  
    public static void main(String args[]) throws IOException {  
        write();  
        read();  
    }  
      
    public static void write() throws IOException {  
        //以读写的方式来访问该文件  
        RandomAccessFile raf = new RandomAccessFile("D:\\test.txt", "rw");  
        raf.writeBytes("Hello World!");  
        raf.writeBoolean(true);  
        raf.writeInt(30);  
        raf.writeDouble(3.56);  
        raf.close();  
    }  
      
    public static void read() throws IOException {  
        RandomAccessFile raf = new RandomAccessFile("D:\\test.txt", "r");  
        raf.seek(12);//设置指针的位置  
        boolean booleanValue = raf.readBoolean();  
        int intValue = raf.readInt();  
        double doubleValue = raf.readDouble();  
        raf.seek(0);//设置指针的位置为文件的开始部分  
        byte[] bytes = new byte[12];  
        for (int i=0; i<bytes.length; i++)  
            bytes[i] = raf.readByte();//每次读一个字节，并把它赋值给字节bytes[i]  
        String stringValue = new String(bytes);  
        raf.skipBytes(1);//指针跳过一个字节  
        int intValue2 = raf.readInt();  
        raf.close();  
        System.out.println(booleanValue);  
        System.out.println(intValue);  
        System.out.println(doubleValue);  
        System.out.println(stringValue);  
        System.out.println(intValue2);  
    }  
      
}  