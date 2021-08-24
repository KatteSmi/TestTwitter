package example;

import org.testng.Assert;
import org.testng.annotations.Test;
import twitter.HomePage;

public class TestTwitterText extends LoginTest{
    HomePage homeObject;

    @Test
    public void tweetWithText() {
        String generatedString = "Встречайте!";

        homeObject = new HomePage(driver);
        homeObject.userTweet(generatedString);
        homeObject.submitTweet();

        Assert.assertTrue(homeObject.messageDisplay());
    }
}
