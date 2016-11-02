package net.hubs1.com.Serialize;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class TestSerialize {
 
    /**
      * @param args
      * @throws IOException
      * @throws ClassNotFoundException
      */
    public static void main(String[] args) throws IOException,
           ClassNotFoundException {
 
       // 1. 序列化文件保存的地址
       String sFilePath = "D:\\jimasFile\\serialize/test_serialize.oo" ;
 
       // 2. 序列化对象到文件中
       testWriteObject (sFilePath);
 
       // 读取字段
       testReadObject (sFilePath);
    }
 
    /**
      * 序列化一个 aStudent 对象到文件中
      *
      * @throws IOException
      */
    private static void testWriteObject(String _sFilePath) throws IOException {
       // 1. 构造 SerializeStudent 对象
       SerializeStudent aStudent = new SerializeStudent();
       aStudent.setStudentName( "wuguowei" ); // 非瞬时态又是非静态字段，所以肯定会序列化
       aStudent.setDept( "computer " ); // dept 是 static ，这里不会被序列化，如果被序列化的话，那么值应该为 computer
       aStudent.setClass( "04133" ); // 由于 class 是 transient ，所以不会被序列化
 
       // 2. 构造序列化流
       FileOutputStream fos = null ;
       ObjectOutputStream ooS = null ;
       try {
           fos = new FileOutputStream(_sFilePath);
           ooS = new ObjectOutputStream(fos);
           ooS.writeObject(aStudent);
       } catch (Exception ex) {
           ex.printStackTrace();
       } finally {
           if (fos != null )
              fos.close();
           if (ooS != null ) {
              ooS.close();
           }
       }
 
       // 3. 还原静态字段，以免影响测试
       aStudent.setDept( null );
    }
 
    /**
      * 从序列化文件中读取出 serializeStudent 对象
      *
      * @throws IOException
      */
    private static void testReadObject(String _sFilePath) throws IOException {
 
       // 1. 从序列化文件中读取出文件
       FileInputStream fiStream = null ;
       ObjectInputStream oiStream = null ;
       try {
           fiStream = new FileInputStream(_sFilePath);
           oiStream = new ObjectInputStream(fiStream);
 
           // 读取信息
           SerializeStudent readStudent = (SerializeStudent) oiStream
                  .readObject();
           System. out .println( " 当前学生信息 ::" + readStudent);
       } catch (Exception ex) {
           ex.printStackTrace();
       } finally {
           if (fiStream != null )
              fiStream.close();
           if (oiStream != null ) {
              oiStream.close();
           }
       }
    }
}