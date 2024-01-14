package testcase;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import util.Utility;

import java.io.IOException;

import static util.Utility.captureScreenshot;

public class TC02_LoginWithRegisteredUser extends TestBase{

    String userName = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/validloginData.json", "userName");
    //String password = Utility.getExcelData(0, 0, "loginData");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/validloginData.json", "password");

    public TC02_LoginWithRegisteredUser() throws IOException, ParseException {
    }

    @Test
    public void loginWithRegisterUser(){
        new P01_HomePage(driver).fillUserNameForLogin(userName).fillPasswordForLogin(password).clickOnSubmitLogin();
        captureScreenshot(driver,"UserLoginCorrect");
        Assert.assertTrue(new P01_HomePage(driver).validateUserLogged());
    }
}
