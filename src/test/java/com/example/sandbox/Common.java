package com.example.sandbox;

import io.restassured.response.Response;
import com.example.sandbox.util.swagger.definitions.User;
import java.util.List;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Common extends Endpoints {

    //----------------------------------GET----------------------------------
    public Response getUrl(String endpoint){
        return given()
                .relaxedHTTPSValidation()
                .and()
                .log().everything()
                .when()
                .get(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    public Response getUrl(String endpoint, Map<String, String> queryParam ){


        return given()
                .relaxedHTTPSValidation()
                .params(queryParam)
                .and()
                .log().everything()
                .when()
                .get(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    public Response getUrl(String endpoint,Map<String, String> headers,Map<String, String> queryParam ){


        return given()
                .relaxedHTTPSValidation()
                .params(queryParam)
                .headers(headers)
                .and()
                .log().all()
                .when()
                .get(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }

    //----------------------------------POST----------------------------------
    public Response postUrl(String endpoint,String body){
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .body(body)
                .and()
                .log().everything()
                .when()
                .post(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();
    }

    public Response postUrl(String endpoint, User[] users) {
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .body(users)
                .log().everything()
                .when()
                .post(baseUrl + endpoint)
                .then()
                .log()
                .all()
                .extract().response();
    }

    public Response postUrl(String endpoint, List<User> userList) {
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .body(userList)
                .log().everything()
                .when()
                .post(baseUrl + endpoint)
                .then()
                .log()
                .all()
                .extract().response();
    }

    //----------------------------------PUT----------------------------------

    public Response putUrl(String endpoint, String requestBody) {
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(requestBody)
                .log().everything()
                .when()
                .put(baseUrl + endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    //----------------------------------DELETE----------------------------------

    public Response deleteUrl(String endpoint, String petId) {
        return given()
                .relaxedHTTPSValidation()
                .log().everything()
                .when()
                .delete(baseUrl + endpoint.replace("{petId}", petId))
                .then()
                .log().all()
                .extract().response();
    }
}

