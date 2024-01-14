package testcase;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_OpenAccountPage;
import util.Utility;

import java.io.IOException;

import static util.Utility.captureScreenshot;

public class TC03_OpenAccount extends TestBase{
    String userName = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/validloginData.json", "userName");
    //String password = Utility.getExcelData(0, 0, "loginData");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/validloginData.json", "password");

    public TC03_OpenAccount() throws IOException, ParseException {
    }

    @Test
    public void openAccount() throws InterruptedException {
        new P01_HomePage(driver).fillUserNameForLogin(userName).fillPasswordForLogin(password).clickOnSubmitLogin();
        Assert.assertTrue(new P01_HomePage(driver).validateUserLogged());

        new P01_HomePage(driver).clickOnOpenNewAcc();
        new P03_OpenAccountPage(driver).selectRandomAccType().selectExistingAcc().clickOnSubmitOpenNewAccount();
        captureScreenshot(driver,"NewAccountOpen");
        Assert.assertEquals("Congratulations, your account is now open.", new P03_OpenAccountPage(driver).validateNewAccOpen());

        //String newAccountNumber = new P03_OpenAccountPage(driver).getNewAccountNumber();
       // System.out.println(newAccountNumber);
    }
}
