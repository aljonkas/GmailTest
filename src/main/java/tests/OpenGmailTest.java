package tests;


/*- Открыть gmail.
- Залогиниться в аккаунт (предварительно создан).
- Проверить, что пользователь залогинился.*/

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;



public class OpenGmailTest {
    private WebDriver driver;
    private HomePage home;

    @BeforeTest
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void goToGmailTest() {
        home = new HomePage(driver);
        home.goToLogin();
        home.goToVerify();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
