package net.hubs1.com.Serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化操作
 * @author weqinjia.liu
 * @Date 2016年8月11日
 */
public class TestAnotherSerialize {

	private static String sFilePath=null;

	public static void main(String[] args) throws IOException {
		List<String> dataList=new ArrayList<String>();
		//准备数据
		dataList.add("jimas");
		dataList.add("jiajia");
		dataList.add("佳佳");
		
		//构建序列号流
		
		sFilePath="D:\\jimasFile\\serialize\\list_serialize.dat";
		
		SerializeObject(dataList);
		Object obj=unSerializeObject(sFilePath);
		System.out.println((List<?>)obj);
		System.out.println(((List<?>)obj).get(0));
		
	}

	/**
	 * 反序列化
	 * @param sFilePath2
	 * @return
	 * @throws IOException 
	 */
	private static Object unSerializeObject(String sFilePath2) throws IOException {
		FileInputStream fis=null;
		ObjectInputStream oiS=null;
		try {
			fis=new FileInputStream(sFilePath2);
			oiS=new ObjectInputStream(fis);
			return oiS.readObject();
		} catch (Exception e) {
			 e.printStackTrace();
		}finally{
			if(fis!=null){
				fis.close();
			}
			if(oiS!=null){
				oiS.close();
			}
		}
		return null;
	}

	/**
	 * 序列化
	 * @param dataList
	 * @throws IOException
	 */
	private static void SerializeObject(List<String> dataList)
			throws IOException {
		FileOutputStream fos = null;
        ObjectOutputStream ooS = null;

		try {
			fos = new FileOutputStream(sFilePath);
			ooS=new ObjectOutputStream(fos);
			ooS.writeObject(dataList);
			System.out.println("Serialize dat success ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fos!=null){
				fos.close();
			}
			if(ooS!=null){
				ooS.close();
			}
		}
	}

}
