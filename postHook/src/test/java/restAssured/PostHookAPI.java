package restAssured;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class PostHookAPI {
	
	// https://posthook-api.mock.beeceptor.com

	// Schedule a hook
	@Test(priority = 0)
	public void scheduleAHook() {
		
		given().when().post("https://posthook-api.mock.beeceptor.com/v1/hooks").then().log().all();
	}
	
	// Get a Hook
	@Test(priority = 1)
	public void getAHook() {
		
		given().when().get("https://posthook-api.mock.beeceptor.com/v1/hooks").then().statusCode(200)
				.log().all();
		given().when().get("https://posthook-api.mock.beeceptor.com/v1/hooks").then().statusCode(200)
		.log().all();

	}
	// get a hook with id
	@Test(priority = 2)
	public void getHookwithID() {
		given().when().get("https://posthook-api.mock.beeceptor.com/v1/hooks/0525baf7-79f9-4991-bb39-6a601ead00e5").then().statusCode(200)
				.log().all();
	}
	
	// Delete a hook
	@Test(priority = 3)
	public void deleteAHook() {
		System.out.println("This is delete hook");
		given().when().delete("https://posthook-api.mock.beeceptor.com/v1/hooks/0525baf7-79f9-4991-bb39-6a601ead00e5").then().statusCode(200)
		.log().all();
	}
	
	// put data
	@Test(priority = 4)
	public void putData() {
		
		JSONObject js = new JSONObject();
		js.put("name", "updated-project");
		js.put("domain", "api.example.com");
		js.put("headerAuthorization", "");
		js.put("minRetries", "1");
		js.put("retryDelaySecs", "5");
		
		given().contentType("application/json").body(js.toJSONString()).when().put("https://posthook-api.mock.beeceptor.com/v1/projects/").then().statusCode(200)
		.log().all();
	}
		
}
