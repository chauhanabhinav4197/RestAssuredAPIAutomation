package DAY3_Cookies_Path_Parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Day3 {
    
    //@Test()
    public void testQueryAndParameter()
    {

        given()
            .pathParam("mypath", "users")
            .queryParam("page", 2)
            .queryParam("id", 2)
        .when()
            .get("https://reqres.in/api/{mypath}")
        .then()
            .statusCode(200)
            .log().all();
    }

    //@Test()
    public void validateCookiesUsingThen()
    {
        given()

        .when()
            .get("https://www.google.com/")
        .then()
            .cookies("AEC", "AVcja2eU_DdUNJm17FH-gkp7UC9HOOq0NwMikWjOcemlvYpzXoRNM1PW0FQ");

    }

    //@Test()
    public void getCookies()
    {
       Response res =  given()

        .when()
            .get("https://www.google.com/");


        // String cookieValue = res.getCookie("AEC");
        // System.out.println(cookieValue);

        Map<String,String> cookiesResponse = res.getCookies();

        for(String key : cookiesResponse.keySet())
        {
            System.out.println(key+"  --  "+res.getCookie(key));
        }
    }

    //@Test()
    public void validateheadersUsingThen()
    {
        given()

        .when()
            .get("https://www.google.com/")
        .then()
            .header("Content-Type", "text/html; charset=ISO-8859-1")
            .header("Content-Encoding", "gzip")
            .header("Server", "gws");
    }

    //@Test()
    public void getHeaders()
    {
        Response res = given().when().get("https://www.google.com/");
        //String headerValue = res.getHeader("Content-Type");
        //System.out.println(headerValue);   
        
        Headers headersAndValue = res.getHeaders();

        for(Header headerValue : headersAndValue)
        {
            System.out.println(headerValue.getName()+"   -----    "+headerValue.getValue());
        }
    }

    @Test()
    public void getHeadersValueUsingLog()
    {
        given().when().get("https://www.google.com/").then().log().headers();// We can use .body() for body only and .cookies() for cookies only
        
    }
}
