package example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import twitter.LoginPage;
import utilites.Helper;


public class LoginTest {

    public static WebDriver driver;
    LoginPage loginPageObject;

    @BeforeSuite
    public static void openDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://twitter.com/login");
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void userSignUpWithValidData() {
        loginPageObject = new LoginPage(driver);
        loginPageObject.userSignUp("+79772668540", "Bnd%12321");

        Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/home"));
    }

//    @AfterSuite
//    public static void closeDriver() {
//        driver.quit();
//    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}
