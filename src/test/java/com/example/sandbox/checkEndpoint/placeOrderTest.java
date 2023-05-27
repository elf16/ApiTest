package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import com.example.sandbox.util.body.store.PlaceAnOrder;
import com.example.sandbox.util.swagger.definitions.Store;
import com.example.sandbox.util.swagger.definitions.Status;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.body.store.JsonBody.createJsonBody;
import static com.example.sandbox.util.constans.Tags.SMOKE;

public class placeOrderTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1(){
        PlaceAnOrder body = PlaceAnOrder.builder()
                .Store(Store.builder()
                        .id(generateRandomNumber())
                        .petId(generateRandomNumber())
                        .quantity(generateRandomNumber())
                        .shipDate("2023-05-27T12:47:22.599Z")
                        .status(Status.placed)
                        .complete(true)
                        .build()
                ).build();

        Response  response = postUrl(order,createJsonBody(body));
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
    }
}