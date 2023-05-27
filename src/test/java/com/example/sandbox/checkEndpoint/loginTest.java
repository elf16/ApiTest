package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.TreeMap;
import static com.example.sandbox.util.constans.Tags.SMOKE;

public class loginTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("username","SuperHero");
        queryParams.put("password","pw");

        Response response = getUrl(login, queryParams);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");
    }
}