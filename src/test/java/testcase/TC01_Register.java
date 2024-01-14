package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;

import static util.Utility.captureScreenshot;

public class TC01_Register extends TestBase {

    String userName = faker.name().username() + faker.random().nextInt(5555) ;
    String password = faker.internet().password();
    String confirmPassword = password;
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String address1 = faker.address().fullAddress();
    String state = faker.address().state();
    String city = faker.address().city();
    String zipcode = faker.address().zipCode();
    String mobileNo = faker.phoneNumber().phoneNumber();
    String ssn = faker.address().streetAddressNumber();

    @Test(priority = 1, description = " Register with valid data ")
    public void registerWithValidData() throws InterruptedException {

        new P01_HomePage(driver).clickOnRegisterBtn();
        new P02_RegisterPage(driver).fillFirstName(firstName).fillLastName(lastName).fillAddress(address1).
                fillCity(city).fillState(state).fillZipCode(zipcode).fillPhone(mobileNo).fillSsn(ssn).fillUserName(userName).
                fillPassword(password).fillConfirmPassword(confirmPassword).clickOnSubmitRegisterBtn();

        captureScreenshot(driver,"registerAcc");
        Assert.assertEquals("Your account was created successfully. You are now logged in." , new P02_RegisterPage(driver).validateUserRegister());


        new P01_HomePage(driver).clickOnLogoutBtn();
        new P01_HomePage(driver).fillUserNameForLogin(userName).fillPasswordForLogin(password).clickOnSubmitLogin();
        captureScreenshot(driver,"UserLoginCorrect");
        Assert.assertTrue(new P01_HomePage(driver).validateUserLogged());



    }


}
