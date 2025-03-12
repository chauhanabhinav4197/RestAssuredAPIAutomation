package Day1_Starting_Rest_Assured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class start {

int id;

//@Test(priority = 1)
public void HTTP_GET_Request()
{
    
    given()

    .when()
        .get("https://reqres.in/api/users?page=2")
    .then()
        .statusCode(200)
        .body("page",equalTo(2))
        .log().all();

}

@Test(priority = 2)
public void HTTP_POST_Request()
{
 
    HashMap<String,String> data = new HashMap<String,String>();
    data.put("name","Abhinav");
    data.put("job", "trainer");

    id = given()
        .contentType("application/json")
        .body(data)
    .when()
        .post("https://reqres.in/api/users")
        .jsonPath().getInt("id");
    /*.then()
        .statusCode(201)
        .log().all();*/


}

@Test(priority=3,dependsOnMethods = {"HTTP_POST_Request"})
public void updateUser()
{
    HashMap<String,String> data = new HashMap<String,String>();
    data.put("name","Abhinav");
    data.put("job", "leader");

     given()
        .contentType("application/json")
        .body(data)
    .when()
        .put("https://reqres.in/api/users/"+id)

    .then()
        .statusCode(200)
        .log().all();
}

@Test(priority = 4)
public void deleteReq()
{
    given()

    .when()
        .delete("https://reqres.in/api/users/"+id)
    
    .then() 
        .statusCode(204);
}

}
