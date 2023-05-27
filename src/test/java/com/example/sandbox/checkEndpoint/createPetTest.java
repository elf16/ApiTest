package com.example.sandbox.checkEndpoint;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.sandbox.util.body.pet.PostCreatePet;
import com.example.sandbox.util.swagger.definitions.Item;
import com.example.sandbox.util.swagger.definitions.PetBody;
import com.example.sandbox.Common;
import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.body.pet.JsonBody.createJsonBody;
import static com.example.sandbox.util.constans.TestData.SPIDERMAN;
import static com.example.sandbox.util.constans.Tags.SMOKE;

public class createPetTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1(){
        PostCreatePet body = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        .id(generateRandomNumber())
                        .category(Item.builder()
                                .id(1)
                                .name("Spider")
                                .build())
                        .name("Man")
                        .photoUrl(SPIDERMAN)
                        .tag(Item.builder()
                                .id(2)
                                .name("lazy")
                                .build())
                        .status("available")
                        .build()
                ).build();

        Response response = postUrl(newPet,createJsonBody(body));
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
    }
}