package com.mailonline.api.steps;

import org.testng.Assert;
import org.testng.Reporter;
import com.mailonline.utils.PayLoadBuilder;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {

	Response response = null;

	@When("^I add a new pet to the store with the \"(.*)\"$")
	public void addPet(String endPoint) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/" + endPoint + "/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json").accept(ContentType.JSON);
		response = request.body(PayLoadBuilder.getAddPetPayload()).post();
		
	}

	@When("^I add a new pet to the store with the \"(.*)\" with invalid id$")
	public void addPetInvalid(String endPoint) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/" + endPoint + "/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json").accept(ContentType.JSON);
		response = request.body(PayLoadBuilder.getInvalidAddPetPayload()).post();
		
	}
	@Then("^I verify the response code as (.*)$")
	public void verifyAddPetStatus(int statusCode) {
		Reporter.log(response.getBody().asString());		
		Reporter.log(String.valueOf(response.statusCode()));
		System.out.println(response.getBody().asString());
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@When("^I get the details of the pet (.*) , \"(.*)\"$")
	public void getPetDetails(int petId,String endPoint) {
		RestAssured.baseURI = "http://petstore.swagger.io/v2/" + endPoint + "/" + petId;
		RequestSpecification request = RestAssured.given();
		response = request.get();		
	}
	
	@When("^I verify the response message as \"(.*)\"$")
	public void verifyInvalidPetMessage(String errorMesg)
	{
		JsonPath jPath = response.jsonPath();
		String message = jPath.getString("message");
		System.out.println(message);
		Reporter.log("ErrorMessage : " + message);			
		Assert.assertEquals(message, errorMesg);
	}
	
}
