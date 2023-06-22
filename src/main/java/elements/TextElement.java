package elements;

public class TextElement extends BasePageObject {
    public TextElement (String name, String locator){
        super(name, locator);
    }

    public String getText() {
        String elementText = getWebElement(getLocator()).getText();
        System.out.println(getName() + " value is " + elementText);
        return elementText;
    }
}
