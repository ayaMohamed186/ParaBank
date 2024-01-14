package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P02_RegisterPage {


    WebDriver driver;

    public P02_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameInputField = By.id("customer.firstName");
    private final By lastNameInputField = By.id("customer.lastName");
    private final By addressInputField = By.id("customer.address.street");
    private final By cityInputField = By.id("customer.address.city");
    private final By stateInputField = By.id("customer.address.state");
    private final By zipCodeInputField = By.id("customer.address.zipCode");
    private final By phoneInputField = By.id("customer.phoneNumber");
    private final By ssnInputField = By.id("customer.ssn");
    private final By userNameInputField = By.id("customer.username");
    private final By passwordInputField = By.id("customer.password");
    private final By confirmPasswordInputField = By.id("repeatedPassword");
    private final By submitRegisterBtn = By.xpath("//input[@value='Register']");
    private final By successMsgOfRegister = By.xpath("//div[@id='rightPanel']/p");


    public P02_RegisterPage fillFirstName(String firstName) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.firstNameInputField));
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }

    public P02_RegisterPage fillLastName(String lastName) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.lastNameInputField));
        driver.findElement(this.lastNameInputField).sendKeys(lastName);
        return this;
    }

    public P02_RegisterPage fillAddress(String address) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addressInputField));
        driver.findElement(this.addressInputField).sendKeys(address);
        return this;
    }

    public P02_RegisterPage fillCity(String city) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.cityInputField));
        driver.findElement(this.cityInputField).sendKeys(city);
        return this;
    }

    public P02_RegisterPage fillState(String state) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.stateInputField));
        driver.findElement(this.stateInputField).sendKeys(state);
        return this;
    }

    public P02_RegisterPage fillZipCode(String zipCode) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.zipCodeInputField));
        driver.findElement(this.zipCodeInputField).sendKeys(zipCode);
        return this;
    }

    public P02_RegisterPage fillPhone(String phone) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.phoneInputField));
        driver.findElement(this.phoneInputField).sendKeys(phone);
        return this;
    }

    public P02_RegisterPage fillSsn(String ssn) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.ssnInputField));
        driver.findElement(this.ssnInputField).sendKeys(ssn);
        return this;
    }

    public P02_RegisterPage fillUserName(String userName) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.userNameInputField));
        driver.findElement(this.userNameInputField).sendKeys(userName);
        return this;
    }

    public P02_RegisterPage fillPassword(String password) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.passwordInputField));
        driver.findElement(this.passwordInputField).sendKeys(password);
        return this;
    }

    public P02_RegisterPage fillConfirmPassword(String confirmPassword) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.confirmPasswordInputField));
        driver.findElement(this.confirmPasswordInputField).sendKeys(confirmPassword);
        return this;
    }

    public P02_RegisterPage clickOnSubmitRegisterBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitRegisterBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.submitRegisterBtn).click();
        return this;
    }


    public String validateUserRegister() {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.successMsgOfRegister));
        return driver.findElement(this.successMsgOfRegister).getText();
    }
}
