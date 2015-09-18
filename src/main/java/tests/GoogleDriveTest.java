package tests;

/*      Открыть gmail.
        Залогиниться в аккаунт (предварительно создан).
        Перейти на гугл-диск.
        Создать папку.
        Проверить, что папка создана.
        Если все ок - удалить папку, как @AfterTest*/


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GoogleDriveTest {

    private WebDriver driver;
    private HomePage home;


    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void goToDriveTest() {
        home = new HomePage(driver);
        home.goToLogin();
        home.goToGoogleDrive();
        home.goToCreateFolder();

    }

    @AfterTest
    public void tearDown() {
        home.removeFolder();
        driver.close();
    }
}
