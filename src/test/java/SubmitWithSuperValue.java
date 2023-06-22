import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.DriverInitializer;
import helpers.Helper;
import org.testng.annotations.*;
import pages.LoanApplicationPage;

import java.io.File;

public class SubmitWithSuperValue extends DriverInitializer {
    LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
    static ExtentReports report;
    Helper helper = new Helper();

    @BeforeClass
    private void openPage(){
        initializeWebDriver("https://laenutaotlus.bigbank.ee/");
        System.out.println("opened");

        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"TestResults_super.html");
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
    public void submitWithSuperValue() {
        ExtentTest testReport = report.createTest("Report_super");

        String newValue = "100000";
        loanApplicationPage.amountField.getFieldValue();
        loanApplicationPage.amountField.clearField();
        loanApplicationPage.amountField.setFieldValue(newValue);
        loanApplicationPage.submitButton.clickButton();
        String amountWithCurrency = loanApplicationPage.loanAmount.getText();
        if (amountWithCurrency.substring(0, amountWithCurrency.length() - 2).equals(helper.getMAX_VALUE())) {
            testReport.log(Status.PASS, "Maximum value was saved");
        } else {
            testReport.log(Status.FAIL, helper.getFAIL());
        }
    }
}
