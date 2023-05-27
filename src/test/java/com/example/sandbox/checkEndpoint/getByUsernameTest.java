package com.example.sandbox.checkEndpoint;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Arrays;
import static com.example.sandbox.util.constans.Tags.SMOKE;

public class getByUsernameTest extends Common {

    //test with the already created usernames
    @Test(enabled = true, groups = {SMOKE}, description = "description")
    public void Test1() {
        List<String> validUsernames = Arrays.asList("username1", "username2");
        for (String username : validUsernames) {
            Response response = getUrl(user.replace("{username}", username));
            Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");
        }
    }

    //test with nonexistent usernames
    @Test(enabled = true, groups = {SMOKE}, description = "description")
    public void Test2() {
        List<String> invalidUsernames = Arrays.asList("username5", "username6");
        for (String username : invalidUsernames) {
            Response response = getUrl(user.replace("{username}", username));
            Assert.assertEquals(response.getStatusCode(), 404, "Invalid response code");
        }
    }
}
