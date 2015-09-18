package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    public static final String ENTER_EMAIL = "qdtnko@gmail.com";
    public static final String ENTER_PASSW = "147asdf147";
    private WebDriver driver;

    @FindBy(id = "gb_70")
    WebElement button;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "next")
    WebElement next;
    @FindBy(id = "signIn")
    WebElement signIn;
    @FindBy(id = "Passwd")
    WebElement passwd;
    @FindBy(css = ".gb_b.gb_Ra.gb_R.gb_Na")
    WebElement accountTitle;

    @FindBy(xpath = ".//*[@id='gbwa']/div[1]/a")
    WebElement link;
    @FindBy(css = ".gb_b.gb_vb")
    WebElement applications;
    @FindBy(xpath = ".//*[@id='gb49']/span[1]")
    WebElement drive;

    @FindBy(xpath =".//*[@id='drive_main_page']/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div")
    WebElement create;
    @FindBy(xpath = ".//*[@class='j-A j-A-Nj']/div[1]")
    WebElement crfolder;
    @FindBy(xpath = ".//*[@class='j-se-Ib j-se-ua']")
    WebElement Ok;

    @FindBy(xpath = ".//*[@id='gb49']/span[1]")
    WebElement span;
    @FindBy(xpath = ".//*[@id='drive_main_page']/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div")
    WebElement div;
    @FindBy(css = ".a-D-P")
    WebElement folder;
    @FindBy(xpath = "html/body/div[11]/div[3]/button[2]")
    WebElement element;
    @FindBy(xpath = "(.//*[@class='k-v-M'])[1]")
    WebElement newFolder;

    public void goToLogin() {
        button.click();
        email.sendKeys(ENTER_EMAIL);
        next.click();
        passwd.sendKeys(ENTER_PASSW);
        signIn.click();
    }

    public void goToGoogleDrive() {
        applications.click();
        drive.click();
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeFolder(){
        Actions action = new Actions(driver);
        action.contextClick(newFolder).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.RETURN).build().perform();

    }


    public void goToVerify() {
        Assert.assertTrue(accountTitle.getText().contains(ENTER_EMAIL));
    }


    public void goToCreateFolder() {
        create.click();
        crfolder.click();
        Ok.click();

    }
}
