package net.hubs1.com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Jsouptest {
	public static void main(String[] args) throws Exception {
		String url = "http://citrix.yun.hubs1.net/Citrix/XenApp/auth/login.aspx";
		Document doc=Jsoup.connect(url).get();
		System.out.println(doc);
	}
}
