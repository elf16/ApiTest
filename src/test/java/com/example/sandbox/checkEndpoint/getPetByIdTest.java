package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.TreeMap;
import static com.example.sandbox.util.constans.Tags.SMOKE;

public class getPetByIdTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","sold");
        Response response = getUrl(findByStatus, queryParams);

        long id = response.jsonPath().getLong("[0].id");

        Response  response2 = getUrl(petById.replace("{petId}", String.valueOf(id)));
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test2(){
        int invalidId = -1;
        Response response2 = getUrl(petById.replace("{petId}", String.valueOf(invalidId)));
        Assert.assertEquals(response2.getStatusCode(), 404, "Invalid response code");
    }
}