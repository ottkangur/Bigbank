package elements;

public class Button extends BasePageObject {
    public Button(String name, String locator) {
        super(name, locator);
    }

    public void clickButton() {
        getWebElement(getLocator()).click();
        System.out.println(getName() + " was clicked");
    }
}
