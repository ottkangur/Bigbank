import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.DriverInitializer;
import helpers.Helper;
import org.testng.annotations.*;
import pages.LoanApplicationPage;

import java.io.File;

public class CloseModalWithMisclick extends DriverInitializer {
    LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
    static ExtentReports report;
    Helper helper = new Helper();

    @BeforeClass
    private void openPage(){
        initializeWebDriver("https://laenutaotlus.bigbank.ee/");
        System.out.println("opened");

        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"TestResults_misclick.html");
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
    public void closeModalWithMisclick() {
        ExtentTest testReport = report.createTest("Report_misclick");

        String newValue = "10000";
        loanApplicationPage.amountField.clickField();
        String initialValue = loanApplicationPage.amountField.getFieldValue();
        loanApplicationPage.amountField.clearField();
        loanApplicationPage.amountField.setFieldValue(newValue);
        loanApplicationPage.randomClickOnPage(getWebDriver());
        String amountWithCurrency = loanApplicationPage.loanAmount.getText();
        if (amountWithCurrency.substring(0, amountWithCurrency.length() - 2).equals(initialValue)) {
            testReport.log(Status.PASS, "Inserted value is not saved when misclicking modal");
        } else {
            testReport.log(Status.FAIL, helper.getFAIL());
        }
    }
}
