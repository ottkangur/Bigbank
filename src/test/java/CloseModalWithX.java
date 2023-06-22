import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.DriverInitializer;
import helpers.Helper;
import org.testng.annotations.*;
import pages.LoanApplicationPage;

import java.io.File;

public class CloseModalWithX extends DriverInitializer {
    LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
    static ExtentReports report;
    Helper helper = new Helper();

    @BeforeClass
    private void openPage(){
        initializeWebDriver("https://laenutaotlus.bigbank.ee/");
        System.out.println("opened");

        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"TestResults_X.html");
        report.attachReporter(spark);
    }

    @AfterClass
    private void closePage(){
        report.flush();

        getWebDriver().close();
        getWebDriver().quit();
        System.out.println("closed");
    }

    @Test
    public void closeModalWithX() {
        ExtentTest testReport = report.createTest("Report_X");

        String newValue = "10000";
        loanApplicationPage.amountField.clickField();
        String initialValue = loanApplicationPage.amountField.getFieldValue();
        loanApplicationPage.amountField.clearField();
        loanApplicationPage.amountField.setFieldValue(newValue);
        loanApplicationPage.closeButton.clickButton();
        String amountWithCurrency = loanApplicationPage.loanAmount.getText();
        if (amountWithCurrency.substring(0, amountWithCurrency.length() - 2).equals(initialValue)) {
            testReport.log(Status.PASS, "Inserted value is not saved when closing modal");
        } else {
            testReport.log(Status.FAIL, helper.getFAIL());
        }
    }
}
