package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class findByStatusTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1() {
        String[] validStatuses = {"available", "pending", "sold"};

        for (String validStatus : validStatuses) {
            Response response = getUrl(findByStatus, Collections.singletonMap("status", validStatus));
            Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
        }
    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test2(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");

        Response response2 = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }
}