package com.m3bi.clientApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.http.converter.json.JsonbHttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaClient {

	public static void main(String[] args) throws IOException  {

//		URL url = new URL("http://localhost:8081/allStudent");
		URL url = new URL("http://localhost:8081/getStudent");
		HttpURLConnection conn= (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();
		System.out.println(conn.getResponseMessage());
		if (responseCode == 200 && "OK".equalsIgnoreCase(conn.getResponseMessage())) {
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		conn.disconnect();
	}

}
