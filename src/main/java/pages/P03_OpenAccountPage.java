package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P03_OpenAccountPage {
    WebDriver driver;
    public P03_OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By submitOpenNewAccBtn = By.xpath("//input[@class='button']");
    private final By successMsgForOpenNewAcc = By.xpath("//div[@ng-if='showResult']/p");
    private final By newAccountNumber = By.xpath("//a[@id='newAccountId']");

    public P03_OpenAccountPage selectRandomAccType() {
        driver.findElement(By.xpath("//div[@ng-if='showForm']/form/select[1]/option["+  generateRandomInt(2) +"]")).
                click();
        return this;
    }
    public P03_OpenAccountPage selectExistingAcc() {
        driver.findElement(By.xpath("//div[@ng-if='showForm']/form/select[2]/option["+  generateRandomInt(1) +"]")).
                click();
        return this;
    }
    public P03_OpenAccountPage clickOnSubmitOpenNewAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitOpenNewAccBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.submitOpenNewAccBtn).click();
        return this;
    }

    public String validateNewAccOpen(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.successMsgForOpenNewAcc));
        return driver.findElement(this.successMsgForOpenNewAcc).getText();
    }

    public String getNewAccountNumber(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.newAccountNumber));
        return driver.findElement(this.newAccountNumber).getText();
    }

}
