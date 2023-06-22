package elements;

import org.openqa.selenium.Keys;

public class InputField extends BasePageObject {
    public InputField(String name, String locator) {
        super(name, locator);
    }

    public void clickField() {
        getWebElement(getLocator()).click();
        System.out.println(getName() + " was clicked");
    }

    public String getFieldValue() {
        String fieldValue = getWebElement(getLocator()).getAttribute("value");
        System.out.println(getName() + " value is " + fieldValue);
        return fieldValue;
    }

    public void clearField(){
        getWebElement(getLocator()).sendKeys(Keys.CONTROL + "a");
        getWebElement(getLocator()).sendKeys(Keys.DELETE);
        System.out.println(getName() + " was cleared");
    }

    public void setFieldValue(String value){
        getWebElement(getLocator()).sendKeys(value);
        System.out.println(getName() + " was updated to " + value);
    }
}
