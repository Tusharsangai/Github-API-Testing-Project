package stepdefination;
//import java.io.IOException;
//
import org.testng.Assert;
//
import static io.restassured.RestAssured.given;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.playloadconverting;
import java.util.HashMap;
public class stepdefination {
	public static String baseURL="https://api.github.com";
	public static String bearer_Token="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";
	RequestSpecification requestspecification;
	Response response;
	JsonPath jsonpath;
	public static String Reponame;
    public static String ShaValue;
	public static int autolinkid;
	
     //CREATE A REPOSITORY
	@Given("Make a post request with the resource {string}")
	public void make_a_post_request_with_the_resource(String resourcepath) {
	   
		 response = given()
		            .baseUri(baseURL)
		            .header("Authorization", "Bearer " + bearer_Token)
		            .contentType(ContentType.JSON)
		            .body("{\n" +
		                    "  \"name\": \"Team-star-catcherapirepo\",\n" +
		                    "  \"description\": \"This is your first repo!\"\n" +
		                    "}")
		            .when()
		            .post(resourcepath);
	}
	@Then("Print the response in console")
	public void print_the_response_in_console() {
		 jsonpath= new JsonPath(response.getBody().asString());
			System.out.println(jsonpath);
	}
	@Then("Store Necessary data in the variable")
	public void store_necessary_data_in_the_variable() {
			 jsonpath= new JsonPath(response.getBody().asString());
				
		       Reponame = jsonpath.get("name");
		       System.out.println(Reponame);
		       System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be {int}")
	public void the_response_status_code_should_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
	@Then("Check Wether the RepoName is stored in variable1 {string}")
	public void check_wether_the_repo_name_is_stored_in_variable1(String reponame) {
		Assert.assertEquals(Reponame, reponame);
		System.out.println(response.getStatusCode());
	}
   
	
	
	
	
	// UPDATE A REPOSITORY
	
	@Given("Make a patch request with resource1 {string}")
	public void make_a_patch_request_with_resource1(String resourcepath) {
	    
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"name\": \"Team-Milkeyway\",\n" +
	                    "  \"description\": \"This is your first repo!\"\n" +
	                    "}")
	            .when()
	            .patch(resourcepath);
		
	}
	@When("Print the response in console of update")
	public void print_the_response_in_console_of_update() {
		jsonpath= new JsonPath(response.getBody().asString());
		System.out.println(jsonpath);
	}
	@Then("Store Necessary data in the variable1")
	public void store_necessary_data_in_the_variable1() {
		
		jsonpath= new JsonPath(response.getBody().asString());
		
	       Reponame = jsonpath.get("name");
	       System.out.println(Reponame);
	}
	@Then("The Response status code should1 be {int}")
	public void the_response_status_code_should1_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
	@Then("Check the Updated RepoName1 {string}")
	public void check_the_updated_repo_name1(String reponame) {
		Assert.assertEquals(Reponame, reponame);
		System.out.println(response.getStatusCode());
	}

	
	
	
	
	
    //GET A REPOSITORY
	
	

	@Given("Make a GET request with resource2 {string}")
	public void make_a_get_request_with_resource2(String resourcepath) {
	    
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath+Reponame);
	}
	@When("Print the response in console2")
	public void print_the_response_in_console2() {
	    
		jsonpath= new JsonPath(response.getBody().asString());
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should2 be {int}")
	public void the_response_status_code_should2_be(int statuscode) {
	    
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
   
	
	
	
	
	
	//CREATE A FILE CONTENT
	
	@Given("Make a PUT request with the resource3 {string}")
	public void make_a_put_request_with_the_resource3(String resourcepath) {
	    
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"message\": \"File Successfully Created\",\n" +
	                    "  \"content\": \"VXBkYXRlZCBIZWxsbyBXb3JsZA==\"\n" +
	                    "}")
	            .when()
	            .put(resourcepath);
		
	}
	@Then("Print the response in console3")
	public void print_the_response_in_console3() {
		jsonpath= new JsonPath(response.getBody().asString());
		System.out.println(jsonpath);
	}
	@Then("Store Necessary data in the variable3")
	public void store_necessary_data_in_the_variable3() {
		jsonpath= new JsonPath(response.getBody().asString());
	    ShaValue = jsonpath.get("content.sha");
	}
	@Then("The response status code should3 be {int}")
	public void the_response_status_code_should3_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
	@Then("Check Wether the sha value is stored in variable2")
	public void check_wether_the_sha_value_is_stored_in_variable2() {
		System.out.println(ShaValue);
	}
	
	
	
	
	
	
	
	//CREATE A FORK

	@Given("Make a POST request with the resource4 {string}")
	public void make_a_post_request_with_the_resource4(String resourcepath) {
	   
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"organization\": \"Tushar-NewOrganization\",\n" +
	                    "  \"name\": \"New-Fork2\"\n" +
	                    "}")
	            .when()
	            .post(resourcepath);
	}
	@Then("Print the response in console4")
	public void print_the_response_in_console4() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should4 be {int}")
	public void the_response_status_code_should4_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}

	
	
	
	
    //LIST OF FORKS
	
	
	@Given("Make a GET request For FORKS with the resource5 {string}")
	public void make_a_get_request_for_forks_with_the_resource5(String resourcepath) throws InterruptedException {
	    
        Thread.sleep(5000);
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath);
		
	}
	@Then("Print the response in console5")
	public void print_the_response_in_console5() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should5 be {int}")
	public void the_response_status_code_should5_be(int statuscode) {
	    
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
   
	
	
	
	
	
	
	//GET A LIST OF REPOSITORY

	@Given("Make a GET request For LIST OF REPOSITORY with the resource6 {string}")
	public void make_a_get_request_for_list_of_repository_with_the_resource6(String resourcepath) {
	   
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath);
	}
	@Then("Print the response in console6")
	public void print_the_response_in_console6() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should6 be {int}")
	public void the_response_status_code_should6_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
   
	
	
	
	
	//LIST REPOSITORY LANGUAGES
	
	@Given("Make a GET request for repositories languages with the resource7 {string}")
	public void make_a_get_request_for_repositories_languages_with_the_resource7(String resourcepath) {
	   
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath);
	}
	@Then("Print the response in console7")
	public void print_the_response_in_console7() {
		System.out.println(response.getBody().asString());
		
	}
	@Then("The response status code should7 be {int}")
	public void the_response_status_code_should7_be(int statuscode) {
	    
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
  
	
	
	
	
	
	//LIST PUBLIC REPOSITORIES
	
	@Given("Make a GET request for public repositories with the resource8 {string}")
	public void make_a_get_request_for_public_repositories_with_the_resource8(String resourcepath) {
	  

		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath);
	}
	@Then("Print the response in console8")
	public void print_the_response_in_console8() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should8 be {int}")
	public void the_response_status_code_should8_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
	
	
	
	
	

    //DELETE A FORK
	
	@Given("Make a Delete request with the resource9 {string}")
	public void make_a_delete_request_with_the_resource9(String resourcepath) {
	    
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .delete(resourcepath);
		
	}
	@Given("The response status code should9 be {int}")
	public void the_response_status_code_should9_be(int statuscode) {
	   	
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
	
	
	
	
	
	
	
	//DELETE A FILE
	
	@Given("Make a Delete file request with the resource10 {string}")
	public void make_a_delete_file_request_with_the_resource10(String resourcepath) {
		
		Map<String, Object> jsonData = new HashMap<String, Object>();
		jsonData.put("message", "deleted file");
		jsonData.put("sha", ShaValue);
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .body(jsonData)
	            .when()
	            .delete(resourcepath);
		
	}
	@Given("The response status code should10 be {int}")
	public void the_response_status_code_should10_be(int statuscode) {
	    
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
	
	
	
	
	
	
	
	//CREATE A RELEASE

	@Given("Make a POST request to create a release with the resource11 {string}")
	public void make_a_post_request_to_create_a_release_with_the_resource11(String resourcepath) {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		jsonData.put("tag_name", "GitHub");
		
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .body(jsonData)
	            .when()
	            .post(resourcepath);
	}
	@Then("Print the response in console11")
	public void print_the_response_in_console11() {
      
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should11 be {int}")
	public void the_response_status_code_should11_be(int statuscode) {
	    
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
  
	
	
	
	
	//LIST REPOSITORY TAGS
	
	@Given("Make a GET request for repositories tags with the resource12 {string}")
	public void make_a_get_request_for_repositories_tags_with_the_resource12(String resourcepath) {
	    
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath);
	}
	@Then("Print the response in console12")
	public void print_the_response_in_console12() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should12 be {int}")
	public void the_response_status_code_should12_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
	
	
	
	
	
	
	//CREATE AN AUTOLINK REFERENCE FOR A REPOSITORY

	@Given("Make a POST request For autolink with the resource13 {string}")
	public void make_a_post_request_for_autolink_with_the_resource13(String resourcepath) {
		response = given()
	            .baseUri(baseURL)
	           .header("Authorization", "Bearer " + bearer_Token)
	           .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"key_prefix\": \"Github-Api-Testing\",\n" +
	                    "  \"url_template\": \"https://example.com/Api?query=<num>\"\n" +
	                    "}")
	            .when()
	            .post(resourcepath);
	}
	@Then("Print the response in console13")
	public void print_the_response_in_console13() {
		System.out.println(response.getBody().asString());
	}
	@Then("Store Necessary data in the variable5")
	public void store_necessary_data_in_the_variable5() {
		jsonpath= new JsonPath(response.getBody().asString());
	    autolinkid = jsonpath.get("id");
	}
	@Then("The response status code should13 be {int}")
	public void the_response_status_code_should13_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}

	
	
	
	
	
    //REPLACE ALL REPOSITORY TOPICS

	@Given("Make a PUT request for repositories topics with the resource14 {string}")
	public void make_a_put_request_for_repositories_topics_with_the_resource14(String resourcepath) {
	    
		Map<String, Object> jsonData = new HashMap<String, Object>();
		String[] myStringArray = {"github", "github-api", "github-api-testing"};
		jsonData.put("names",myStringArray);
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .body(jsonData)
	            .when()
	            .put(resourcepath);
	}
	@Then("Print the response in console14")
	public void print_the_response_in_console14() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should14 be {int}")
	public void the_response_status_code_should14_be(int statuscode) {
	    
		Assert.assertEquals(statuscode, response.getStatusCode());
	}
 
	
	
	
	
	
	//GET ALL REPOSITORY TOPICS
	
	@Given("Make a GET request for repositories topics with the resource15 {string}")
	public void make_a_get_request_for_repositories_topics_with_the_resource15(String resourcepath) {
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath);
	}
	@Then("Print the response in console15")
	public void print_the_response_in_console15() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should15 be {int}")
	public void the_response_status_code_should15_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}

	
	
	
	
	
   //GET AN AUTOLINK REFERENCE OF A REPOSITORY
	
	
	@Given("Make a GET request for repositories autolink with the resource16 {string}")
	public void make_a_get_request_for_repositories_autolink_with_the_resource16(String string) {
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string+autolinkid);
	}
	@Then("Print the response in console16")
	public void print_the_response_in_console16() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should16 be {int}")
	public void the_response_status_code_should16_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}

   
	
	
	//DELETE AN AUTOLINK REFERENCE OF A REPOSITORY

	@Given("Make a Delete request to delete autolink with the resource17 {string}")
	public void make_a_delete_request_to_delete_autolink_with_the_resource17(String string) {
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token )
	            .contentType(ContentType.JSON)
	            .when()
	            .delete(string+autolinkid);
	}
	@Then("The Delete response status code should17 be {int}")
	public void the_delete_response_status_code_should17_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}

	
	
	
    //GET A REPOSITORY
	
	

	@Given("Make a GET request  with the resource18 {string}")
	public void make_a_get_request_with_the_resource18(String resourcepath) {
	   
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(resourcepath);
	}
	@Then("Print the response in console18")
	public void print_the_response_in_console18() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should18 be {int}")
	public void the_response_status_code_should18_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}

	
	
	
	
    //DELETE A REPOSITORY
	
	

	@Given("Make a Delete request with the resource20 {string}")
	public void make_a_delete_request_with_the_resource20(String resourcepath) {
		response = given()
	            .baseUri(baseURL)
	            .header("Authorization", "Bearer " + bearer_Token)
	            .contentType(ContentType.JSON)
	            .when()
	            .delete(resourcepath);
	}
	@Then("The Delete response status code should20 be {int}")
	public void the_delete_response_status_code_should20_be(int statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode());
	}







	















    










	



}
     



