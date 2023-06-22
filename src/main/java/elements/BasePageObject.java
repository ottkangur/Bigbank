package elements;

import common.DriverInitializer;

public class BasePageObject extends DriverInitializer {
    private String name;
    private String locator;

    public BasePageObject(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public String getLocator() {
        return locator;
    }
}
