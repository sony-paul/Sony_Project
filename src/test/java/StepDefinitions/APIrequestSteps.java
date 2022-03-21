package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pages.Abilities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class APIrequestSteps {
	
	Response response;
	
	@Given("I enter auth details")
	public void i_enter_auth_details() {
	   	 given()
		.auth()
		.preemptive()
		.basic("httpwatch", "Testpwd1")
		.when()
		.get("http://www.httpwatch.com/httpgallery/authentication/authenticatedimage/default.aspx?0.7349707232788205") 
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Given("I launch the url")
	public void i_launch_the_url() {
	//	response=
		//get("https://reqres.in/api/users?page=2");
		 given()
		.get("https://reqres.in/api/users?page=2")
	    .then()
	    .statusCode(200)
	    .body("data.id[0]",equalTo(7))
	    .body("data.first_name", hasItems("George"))
	    .log()
	    .all();
	}

	@Then("I can validate response")
	public void i_can_validate_response() {
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
	}
	
	@Given("I provide a post request")
	public void i_provide_a_post_request() {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "morpheus");
		map.put("job", "leader");
		
		ObjectMapper om=new ObjectMapper();
		try {
			System.out.println(om.writeValueAsString(map));
			} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given().header("Content-Type","application/json")
		.body(om)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	   
	}

	@Given("I provide a put request")
	public void i_provide_a_put_request() {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "morpheus");
		map.put("job", "leader");
		
		ObjectMapper om=new ObjectMapper();
		try {
			System.out.println(om.writeValueAsString(map));
			} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given().header("Content-Type","application/json")
		.body(om)
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
	  
	}
	
	@Given("I provide a patch request")
	public void i_provide_a_patch_request() {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "test");
		
		
		ObjectMapper om=new ObjectMapper();
		try {
			System.out.println(om.writeValueAsString(map));
			} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given().header("Content-Type","application/json")
		.body(om)
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
	  
	}
	
	@Given("I provide a delete request")
	public void i_provide_a_delete_request() {

		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all();
	}
	
	@Given("^I enter\"(.*?)\"and\"(.*?)\"$")
	public void i_provide_a_post_request_with_multiple_data(String name,String job) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", name);
		map.put("job", job);
		
		ObjectMapper om=new ObjectMapper();
		try {
			System.out.println(om.writeValueAsString(map));
			} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given().header("Content-Type","application/json")
		.body(om)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();


	}
	
	@Given("a POST request payload check")
	public void a_post_request_payload_check() {
		
		Abilities abilities=new Abilities
				  ("testname","qa",true,1,new String[] {"java","c"},"test","text.com");
		
		given().header("Content-Type","application/json")
		.body(abilities)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	
	}
	
	@Given("I provide a get request for deck of cards")
	public void i_provide_a_get_request_for_deck_of_cards() throws IOException {
	
		Response response= 
		   given()
		   .get("https://pokeapi.co/api/v2/pokemon/ditto");
		   JsonPath j = new JsonPath(response.asString());
		   String name = j.getString("abilities[0].ability.name");
		   String url  = j.getString("abilities[0].ability.url");
		   boolean is_hidden = j.getBoolean("abilities[0].is_hidden");
		   int slot  = j.getInt("abilities[0].slot");
		   			
		  
		   
		   Map<String,Object> map=new HashMap<String,Object>();
			map.put("job", url);
			map.put("is_hidden", is_hidden);
			map.put("slot", slot);
	}
}
