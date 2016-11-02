package net.hubs1.com.weixin;

import java.util.HashMap;
import java.util.Map;

import net.hubs1.com.http.HttpClientUtil;


public class PersonalQrcode {
	 protected static final String BASE_API_URL = " https://api.weixin.qq.com/cgi-bin/qrcode/create";
	 protected static final String BASE_API = "http://open.weixin.qq.com/qr/code";
	 private static final String APPLICATION_JSON = "application/json";
	    
	    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	 
	 public static void main(String[] args) throws Exception {
		String data="kissxiyang";
		 Map<String, Object> map=new HashMap<String, Object>();
		 map.put("username", data);
		 String stringJsonPrama="{\"username\":\"kissxiyang\"}";
		String doJsonPost = HttpClientUtil.doJsonPost(BASE_API, stringJsonPrama, "UTF-8");
		System.out.println(doJsonPost);
	 }
}
