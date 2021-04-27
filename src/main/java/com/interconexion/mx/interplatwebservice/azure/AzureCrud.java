package com.interconexion.mx.interplatwebservice.azure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AzureCrud {

	StringBuilder response = new StringBuilder();
	public static String organizacion = "TestAzureApi/"; 
	public static String proyecto = "Test01/";

	public StringBuilder consultaWorkItem(String urlAPI, String encodedPAT, String json) {
		try {
			URL url = new URL(urlAPI);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Basic " + encodedPAT);
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setDoOutput(true);
			System.out.println("JSON REQUEST: " + json);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = json.getBytes("utf-8");
				os.write(input, 0, input.length);
			}
			int status = con.getResponseCode();
			if (status == 200) {
				try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
						}	
					}
			} else {
				response.append("Error al consultar el Web Service");
			}		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public String url(String complemento)
	{
		String url = "https://dev.azure.com/" + organizacion  + proyecto  + complemento;
		System.out.println("URL:[" + url + "]");
		return url;				
	}
	
	public String jsonQueryWorkItem(String id)
	{
		return"{\r\n"
				+ " 'ids': [\r\n"
				+  id +"\r\n"
				+ " ],\r\n"
				+ " 'fields': [\r\n"
				+ "   'System.Id',\r\n"
				+ "   'System.Title',\r\n"
				+ "   'System.WorkItemType',\r\n"
				+ "   'System.Description',\r\n"
				+ "   'System.State'\r\n"
				+ " ]\r\n"
				+ "}";
	}
}
