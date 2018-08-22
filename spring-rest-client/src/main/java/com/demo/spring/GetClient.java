package com.demo.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {
	
	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		
		String textCredentials="pavan:welcome1";
		String encodedCredentials=new String(Base64.encodeBase64(textCredentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic "+encodedCredentials);
		HttpEntity req = new HttpEntity<>(headers);
		
	ResponseEntity<String> response= rt.exchange("http://localhost:8081/app/emp/101", HttpMethod.GET, req, String.class);
				
			System.out.println(response.getBody());

	}
	
	// common codec

}
