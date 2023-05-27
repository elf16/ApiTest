package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import com.example.sandbox.util.swagger.definitions.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Arrays;

import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.constans.Tags.SMOKE;

public class createWithListTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1() {

        User user1 = User.builder()
                .id(generateRandomNumber())
                .username("username3")
                .firstName("FirstN1")
                .lastName("LastN1")
                .email("test1@example.com")
                .password("pw")
                .phone("123456")
                .userStatus(1)
                .build();

        User user2 = User.builder()
                .id(generateRandomNumber())
                .username("username4")
                .firstName("FirstN2")
                .lastName("LastN2")
                .email("test2@example.com")
                .password("pw")
                .phone("123456")
                .userStatus(1)
                .build();

        List<User> userList = Arrays.asList(user1, user2);

        Response response = postUrl(createWithList, userList);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");
    }
}
