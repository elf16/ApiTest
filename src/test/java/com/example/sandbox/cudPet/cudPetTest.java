package com.example.sandbox.cudPet;

import com.example.sandbox.Common;
import com.example.sandbox.util.body.pet.PostCreatePet;
import com.example.sandbox.util.swagger.definitions.Item;
import com.example.sandbox.util.swagger.definitions.PetBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.body.pet.JsonBody.createJsonBody;
import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.TestData.SUPERHERO;

public class cudPetTest extends Common {

    @Test(enabled = true, groups = {SMOKE}, description = "description")
    public void Test1() {

        //create pet
        PostCreatePet createPetBody = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        .id(generateRandomNumber())
                        .category(Item.builder()
                                .id(1)
                                .name("Super")
                                .build())
                        .name("Hero")
                        .photoUrl(SUPERHERO)
                        .tag(Item.builder()
                                .id(2)
                                .name("strong")
                                .build())
                        .status("unique")
                        .build()
                ).build();

        Response createResponse = postUrl(newPet, createJsonBody(createPetBody));
        Assert.assertEquals(createResponse.getStatusCode(), 200, "Invalid response code");
        Long petId = createResponse.jsonPath().getLong("id");

        //update pet
        PostCreatePet updatedPetBody = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        .id(petId.intValue())
                        .category(Item.builder()
                                .id(1)
                                .name("Modified Super")
                                .build())
                        .name("Modified Hero")
                        .photoUrl(SUPERHERO)
                        .tag(Item.builder()
                                .id(2)
                                .name("Modified strong")
                                .build())
                        .status("modified")
                        .build()
                ).build();

        Response updateResponse = putUrl(updatePet, createJsonBody(updatedPetBody));
        Assert.assertEquals(updateResponse.getStatusCode(), 200, "Invalid response code");

        //check successful update
        Response getResponse = getUrl(petById.replace("{petId}", String.valueOf(updateResponse.jsonPath().getLong("id"))));
        Assert.assertEquals(getResponse.getStatusCode(), 200, "Invalid response code");

        //delete pet
        Response deleteResponse = deleteUrl(deletePet, String.valueOf(updateResponse.jsonPath().getLong("id")));
        Assert.assertEquals(deleteResponse.getStatusCode(), 200, "Invalid response code");

        //check succesful deletion
        Response getByIdResponse = getUrl(petById.replace("{petId}", String.valueOf(createResponse.jsonPath().getLong("id"))));
        Assert.assertEquals(getByIdResponse.getStatusCode(), 404, "Invalid response code");
    }
}