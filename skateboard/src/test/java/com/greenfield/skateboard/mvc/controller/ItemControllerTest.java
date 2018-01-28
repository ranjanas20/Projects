package com.greenfield.skateboard.mvc.controller;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.greenfield.skateboard.entity.Item;


/**
 * Tests the  RESTFul Order service on http
 * */
public class ItemControllerTest {
	String baseUrl = "http://localhost:8080/items";

	@Test
	public void order1(){
		Item item = new Item();
		item.setDescription("Item1");
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		//requestHeaders.put("Authorization","Basic 54a71c53-290b-443a-bbe1-46eaddf0ac16");
		HttpEntity<Item> entity = new HttpEntity<Item>(
				item, requestHeaders);

		ResponseEntity<String> result = restTemplate.exchange(
				baseUrl, HttpMethod.GET,entity, String.class);
		System.out.println("Response Status: "+result.getStatusCode());
		System.out.println(result.getBody());
		//Need assertions
	}
}
