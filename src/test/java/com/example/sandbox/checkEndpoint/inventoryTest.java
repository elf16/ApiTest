package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.example.sandbox.util.constans.Tags.SMOKE;

public class inventoryTest extends Common {

    @Test(enabled = true, groups = {SMOKE}, description = "description")
    public void Test1() {
        Response response = getUrl(inventory);
        Assert.assertEquals(200, response.getStatusCode());
    }
}