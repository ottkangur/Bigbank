package pages;

import elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoanApplicationPage {
    public Button submitButton = new Button("Submit button", "class=bb-calculator-modal__submit-button");
    public Button closeButton = new Button("Close button", "class=bb-modal__close");
    public InputField amountField = new InputField("Amount field", "name=header-calculator-amount");
    public InputField periodField = new InputField("Period field", "name=header-calculator-period");
    public TextElement loanAmount = new TextElement("Loan amount", "class=bb-edit-amount__amount");

    public void randomClickOnPage(WebDriver webDriver) {
        Actions actions = new Actions(webDriver);
        actions.moveByOffset(10, 10).click();
    }
}
