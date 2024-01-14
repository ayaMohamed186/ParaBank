package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P01_HomePage {
    WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registerBtn = By.xpath("//div[@id=\"loginPanel\"]/p[2]/a");
    private final By userNameForLogin = By.xpath("//input[@name='username']");
    private final By passwordForLogin = By.xpath("//input[@type='password']");
    private final By submitLoginBtn = By.xpath("//input[@value='Log In']");
    public final By logoutBtn = By.xpath("//div[@id='leftPanel']/ul/li[8]/a");
    private final By openNewAccountBtn = By.xpath("//div[@id='leftPanel']/ul/li[1]/a");
    private final By fundTransferBtn = By.xpath("//div[@id='leftPanel']/ul/li[3]/a");

    public P01_HomePage clickOnRegisterBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.registerBtn).click();
        return this;
    }

    public P01_HomePage clickOnLogoutBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.logoutBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.logoutBtn).click();
        return this;
    }

    public P01_HomePage fillUserNameForLogin(String userNameForLogin) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.userNameForLogin));
        driver.findElement(this.userNameForLogin).sendKeys(userNameForLogin);
        return this;
    }

    public P01_HomePage fillPasswordForLogin(String userNameForLogin) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.passwordForLogin));
        driver.findElement(this.passwordForLogin).sendKeys(userNameForLogin);
        return this;
    }

    public P01_HomePage clickOnSubmitLogin() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitLoginBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.submitLoginBtn).click();
        return this;
    }

    public boolean validateUserLogged() {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.logoutBtn));
        return driver.findElement(this.logoutBtn).isDisplayed();
    }
    public P01_HomePage clickOnOpenNewAcc() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.openNewAccountBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.openNewAccountBtn).click();
        return this;
    }
    public P01_HomePage clickOnFundTransferBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.fundTransferBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.fundTransferBtn).click();
        return this;
    }

}
