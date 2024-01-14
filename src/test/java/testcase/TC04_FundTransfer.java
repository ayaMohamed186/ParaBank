package testcase;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P04_FundTransferPage;
import util.Utility;

import java.io.IOException;

import static util.Utility.captureScreenshot;

public class TC04_FundTransfer extends TestBase{
    String userName = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/validloginData.json", "userName");
    //String password = Utility.getExcelData(0, 0, "Sheet1");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/validloginData.json", "password");

    public TC04_FundTransfer() throws IOException, ParseException {
    }
    String amount = "100";
    int index = 0;
    int indexTo = 1;

    @Test
    public void fundTransfer() throws InterruptedException {
        new P01_HomePage(driver).fillUserNameForLogin(userName).fillPasswordForLogin(password).clickOnSubmitLogin();
        Assert.assertTrue(new P01_HomePage(driver).validateUserLogged());

        new P01_HomePage(driver).clickOnFundTransferBtn();
        Thread.sleep(2000);
        new P04_FundTransferPage(driver).selectToAccField(indexTo);
        new P04_FundTransferPage(driver).fillAmountField(amount).clickOnTransferBtn();
        captureScreenshot(driver,"FundTransferred");
        Assert.assertTrue(new P04_FundTransferPage(driver).getAmountDisplayedAfterTransfer().contains(amount));

        System.out.println(new P04_FundTransferPage(driver).getAmountDisplayedAfterTransfer().contains(amount));

    }
}
