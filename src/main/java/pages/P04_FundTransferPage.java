package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P04_FundTransferPage {
    WebDriver driver;

    public P04_FundTransferPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By amountInputField = By.id("amount");
    private final By fromAccField = By.id("fromAccountId");
    private final By toAccField = By.id("toAccountId");
    private final By transferBtn = By.xpath("//input[@value='Transfer']");
    private final By transferSuccessMsg = By.xpath("(//div[@class='ng-scope'])[2]/p");


    public P04_FundTransferPage fillAmountField(String amount) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.amountInputField));
        driver.findElement(this.amountInputField).sendKeys(amount);
        return this;
    }

    public P04_FundTransferPage selectFromAccField(int index){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.fromAccField));
        WebElement fromAccEle = driver.findElement(this.fromAccField);
        Select fromAcc = new Select(fromAccEle);
        fromAcc.selectByIndex(index);
        return this;
    }

    public P04_FundTransferPage selectToAccField(int index){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.toAccField));
        WebElement toAccEle = driver.findElement(this.toAccField);
        Select toAcc = new Select(toAccEle);
        toAcc.selectByIndex(index);
        return this;
    }

    public P04_FundTransferPage clickOnTransferBtn() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.transferBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.transferBtn).click();
        return this;
    }

    public String getAmountDisplayedAfterTransfer(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.transferSuccessMsg));
        return driver.findElement(this.transferSuccessMsg).getText();
    }

}
