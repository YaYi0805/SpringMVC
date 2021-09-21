package tw.yayichen.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RssController {
	
	private String result;
	
	@GetMapping(path = "/rssreader.controller", produces = "application/xml;charset=UTF-8")
	@ResponseBody
	public String processRssAction() throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				URL url;
				try {
					url = new URL("https://www.mohw.gov.tw/rss-16-1.html");
					HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.setDoInput(true);
					conn.connect();
					
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String data = "";
					result = "";
					while((data = br.readLine())!=null) {
						result = result + data;
					}
					br.close();
					conn.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		};
		t1.start();
		t1.join();
		System.out.println("result:" + result);
		return result;
	}
}
