package com.mailonline.api.steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {
	
public static void addPet()
{
	
	RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json")		
	.accept(ContentType.JSON);
	
	String s = "{\"id\": 58,\"name\": \"pinky\"}";	 
	Response response  = request.body(s)
			.post();
	
	System.out.println(response.getBody().asString());
	System.out.println(response.statusCode());
	}

public static void getPetDetails()
{
	RestAssured.baseURI = "http://petstore.swagger.io/v2/pet/58";
	RequestSpecification request = RestAssured.given();      
	Response response = request.get();
	String responseBody = response.getBody().asString();
	System.out.println(responseBody);
	}
 public static void main(String[] args) {
	 addPet();
	 getPetDetails();
}
}
