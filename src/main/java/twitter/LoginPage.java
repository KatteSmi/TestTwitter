package twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    public WebDriver driver;
    private final By usernameField = By.cssSelector("input[name='session[username_or_email]']");
    private final By passwordField = By.cssSelector("input[name='session[password]']");
    private final By loginButton = By.cssSelector("div[data-testid='LoginForm_Login_Button']");

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void userSignUp(String phone, String Password) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(usernameField).sendKeys(phone);
        driver.findElement(passwordField).sendKeys(Password);
        driver.findElement(loginButton).click();
    }
}
