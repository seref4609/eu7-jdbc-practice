package apitests.example;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;

public class selfExample {


    @Test
    public void test1() {

        String urlspar = "http://18.233.164.111:8000/api/spartans/";

        Response response = RestAssured.get(urlspar);
        System.out.println("response = " + response.asString());

        response = given().accept(ContentType.JSON)
                .when().get(urlspar);
        int i = response.statusCode();
        System.out.println("statusCode = " + i);
/*
        Assert.assertEquals(response.statusCode(),200);
       Assert.assertEquals(response.contentType(),"application/json");
         */
        response.prettyPrint();
        System.out.println("response.getHeaders() = " + response.getHeaders());

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json");

    }

    @Test
    public void test2() {
/*
        Given accept type is json
        When user sends get request to regions/2
        Then response status code must be 200
        and body is json format
        and response body contains Americas
     */
        String hrurl = "http://18.233.164.111:1000/ords/hr";

        Response response = given().accept(ContentType.JSON)
                .when().get(hrurl + "/regions/2");

        response.prettyPrint();

        response.then().assertThat().statusCode(200)
                .contentType("application/json");

        String getBodyText = response.body().asString();
        System.out.println("getBody = " + getBodyText);
        Assert.assertTrue(getBodyText.contains("America"));


    }

    @Test
    public void test3() {
        // only get request
        String urlspar = "http://18.233.164.111:8000";
        Response response = when().get(urlspar + "/api/spartans");

        response.then().assertThat().statusCode(200);

    }

    @Test
    public void test4() {
        String urlspar = "http://18.233.164.111:8000";
         /* TASK
        When users sends a get request to /api/spartans/3
        Then status code should be 200
        And content type should be application/json;charset=UTF-8
        and json body should contain Fidole
     */

        Response response = when().get(urlspar + "/api/spartans/3");
        response.then().assertThat().statusCode(200).contentType("application/json");
        Assert.assertTrue(response.body().asString().contains("Fidole"));

    }

    @Test
    public void testHelloFromSparta() {
        /*
        Given no headers provided
        When Users sends GET request to /api/hello
        Then response status code should be 200
        And Content type header should be “text/plain;charset=UTF-8”
        And header should contain date
        And Content-Length should be 17
        And body should be “Hello from Sparta"
        */
        String urlspar = "http://18.233.164.111:8000";
        Response response = when().get(urlspar + "/api/hello");
        response.then().assertThat().statusCode(200).and().contentType("text/plain;charset=UTF-8");

        Assert.assertTrue(response.headers().hasHeaderWithName("date"));
        Assert.assertEquals(response.header("Content-Length"), "17");
        Assert.assertEquals(response.body().asString(), ("Hello from Sparta"));

    }
    @Test
    public void testWithParameter(){

        String url="http://18.233.164.111:8000";
         /*
          Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json;charset=UTF-8
          And "Blythe" should be in response payload
       */

   RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",5)
                .when().get(url+"/api/spartans/{id}").then().statusCode(200)
                .contentType("application/json");
   Response response=given().accept(ContentType.JSON)
           .and().pathParam("id",5).when().get(url+"/api/spartans/{id}");
   Assert.assertTrue(response.body().asString().contains("Blythe"));

    /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json;charset=UTF-8
        And "Spartan Not Found" message should be in response payload
     */
    }
    @Test
    public void test6(){
        String url="http://18.233.164.111:8000";
        Response response=given().accept(ContentType.JSON).and().pathParam("id",500)
                .when().get(url+"/api/spartans/{id}");
        Assert.assertEquals(response.statusCode(),404);
        Assert.assertEquals(response.contentType(),"application/json");

    }
      /*
        Given accept type is Json
        And query parameter values are :
        gender|Female
        nameContains|e
        When user sends GET request to /api/spartans/search
        Then response status code should be 200
        And response content-type: application/json;charset=UTF-8
        And "Female" should be in response payload
        And "Janette" should be in response payload
     */
      @Test
      public void queryParameters(){
          String url="http://18.233.164.111:8000";
          Response response=given().accept(ContentType.JSON).and()
                  .queryParam("gender","Female").and().
                  queryParam("nameContains","e").when().get(url+"/api/spartans/search");

          Assert.assertEquals(response.statusCode(),200);
          Assert.assertTrue(response.body().asString().contains("Janette"));

          JsonPath jsonPath=response.jsonPath();

          System.out.println("response.path(\"content.id[0]\") = " +jsonPath.get("content.name[5]"));

      }
    @Test
    public void queryParametersMaps(){
        String url="http://18.233.164.111:8000";

        //create a map and add query parameters
        Map<String,Object>mapList=new HashMap<>();
        mapList.put(" gender","Female");
        mapList.put(" nameContains","e");
        System.out.println("mapList = " + mapList);

        //List<Map<String, Object>> list=new ArrayList<>();
       // list.add(mapList);
       // System.out.println("list = " + list);
        Response response=given().accept(ContentType.JSON).and()
                .queryParams(mapList).when().get(url+"/api/spartans/search");




    }


}
