package apitests.reviewWithOscar.avengersAPIReview;

import io.restassured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetRequest {
    String hrUrl = "http://54.91.210.3:1000/ords/hr";

    @Test
    public void testOne() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(hrUrl + "/employees");

        //response.prettyPrint();
        // status code and content type
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");

        // headers
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));
        Assert.assertEquals(response.header("Transfer-Encoding"), "chunked");

        Assert.assertTrue(response.asString().contains("Steven"));

    }

    @Test
    public void testTwo() {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .and().pathParam("id", 105)
                .when().get(hrUrl + "/employees/{id}");
        response.prettyPrint();

        String jop_id = response.path("jop_id");
        System.out.println("jop_id = " + jop_id);
        Assert.assertEquals(jop_id, "IT_PROG");

        JsonPath jsonPath=response.jsonPath();

        //Assert.assertEquals(jsonPath.getString(""));

    }
}







