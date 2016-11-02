package net.hubs1.com.jsoup;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestGetUrlInfo {

	public static void main(String[] args) {
		String ip="220.178.1.10";
		String url = "http://citrix.yun.hubs1.net/Citrix/XenApp/auth/login.aspx";
//		String url = "http://www.ip138.com/ips138.asp?ip=" + ip + "&action=2";
		getInfoByUrl(url);

	}
	public static String getInfoByUrl(String url){
		String result=null;
		try {
			CloseableHttpResponse response = null;
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet htpGet=new HttpGet(url);
			response=client.execute(htpGet);  
//			String result = EntityUtils.toString(response.getEntity(),"UTF-8");  
			result= EntityUtils.toString(response.getEntity(),"GB2312");  
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
