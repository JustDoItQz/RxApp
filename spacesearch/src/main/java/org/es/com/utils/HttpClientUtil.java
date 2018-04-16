package org.es.com.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	
	private static  Log log=LogFactory.getLog(HttpClientUtil.class);

	public static DefaultHttpClient httpClient = null;

	public static HttpClient getInstance() {
		if (httpClient == null) {
			httpClient = new DefaultHttpClient();
		}
		return httpClient;
	}

	public static void disconnect() {
		httpClient = null;
	}

	public static String doGet(String url) {
		return doGet(url, new ArrayList<BasicNameValuePair>());
	}

	public static String doGet(String url, List<BasicNameValuePair> data) {
		/* 建立HTTP Post连线 */
		HttpGet httpGet = new HttpGet(url);
		try {
			httpGet.addHeader("Connection", "close");
			HttpResponse httpResponse = HttpClientUtil.getInstance().execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(httpResponse.getEntity());
			} else {
				log.error("doGet Error Response: " + httpResponse.getStatusLine().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String doPost(String url) {
		return doPost(url, new ArrayList<BasicNameValuePair>());
	}

	public static String doPost(String url, List<BasicNameValuePair> data) {
		/* 建立HTTP Post连线 */
		HttpPost httpPost = new HttpPost(url);
		try {
			httpPost.addHeader("Connection", "close");
			// 发出HTTP request
			// httpPost.setEntity(new UrlEncodedFormEntity(data, HTTP.UTF_8));
			httpPost.setEntity(new UrlEncodedFormEntity(data, "UTF-8"));
			// 取得HTTP response
			HttpResponse httpResponse = HttpClientUtil.getInstance().execute(httpPost);
			// 若状态码为200 ok
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 取出回应字串
				HttpEntity entity=httpResponse.getEntity();
				String content=EntityUtils.toString(httpResponse.getEntity());
				
				return content ;
			} else {
				log.error("doPost Error Response: " + httpResponse.getStatusLine().toString());
				log.error("doPost Error Response body: " + EntityUtils.toString(httpResponse.getEntity()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
