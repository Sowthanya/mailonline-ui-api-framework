package com.mailonline.api.steps;

import org.testng.Assert;
import org.testng.Reporter;

import com.mailonline.utils.Constants;
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
		RestAssured.baseURI = Constants.BASEURL + endPoint + "/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json").accept(ContentType.JSON);
		response = request.body(PayLoadBuilder.getAddPetPayload()).post();
		
	}

	@When("^I add a new pet to the store with the \"(.*)\" with invalid id$")
	public void addPetInvalid(String endPoint) {
		RestAssured.baseURI = Constants.BASEURL + endPoint + "/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json").accept(ContentType.JSON);
		response = request.body(PayLoadBuilder.getInvalidAddPetPayload()).post();
		
	}
	@Then("^I verify the response code as (.*)$")
	public void verifyAddPetStatus(int statusCode) {
		Assert.assertEquals(response.statusCode(), statusCode);
		Reporter.log("Status Code :" + response.statusCode());
		Reporter.log("Response : " + response.getBody().asString());
	}

	@When("^I get the details of the pet (.*) , \"(.*)\"$")
	public void getPetDetails(int petId,String endPoint) {
		RestAssured.baseURI = Constants.BASEURL + endPoint + "/" + petId;
		RequestSpecification request = RestAssured.given();
		response = request.get();		
	}
	
	@Then("^I verify the response message as \"(.*)\"$")
	public void verifyInvalidPetMessage(String errorMesg)
	{
		JsonPath jPath = response.jsonPath();
		String message = jPath.getString("message");
		System.out.println(message);			
		Assert.assertEquals(message, errorMesg);
		Reporter.log("Error message received as expected");	
		Reporter.log("ErrorMessage: " + message);	
	}
	
}
