package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.TestData.SUPERHERO;

public class uploadImageTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1() {
        String petId = "1";
        String baseUrl = "https://petstore.swagger.io/v2";

        Response response = given()
                .relaxedHTTPSValidation()
                .contentType("multipart/form-data")
                .multiPart("file", SUPERHERO)
                .when()
                .post(baseUrl + uploadImage.replace("{petId}", petId))
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");
    }
}