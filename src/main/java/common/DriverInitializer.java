package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class DriverInitializer {
    private static WebDriver webDriver;

    public WebDriver getWebDriver(){
        return this.webDriver;
    }

    public void initializeWebDriver(String url){
        WebDriverManager.chromedriver().setup();
        System.out.println("Setting up newest chromedriver");
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.webDriver.get(url);
    }

    public WebElement getWebElement(String locator) {
        if (locator.startsWith("id=")) {
            String idLocator = locator.substring(3);
            return getWebDriver().findElement(By.id(idLocator));
        } else if (locator.startsWith("name=")) {
            String nameLocator = locator.substring(5);
            return getWebDriver().findElement(By.name(nameLocator));
        } else if (locator.startsWith("class=")) {
            String classLocator = locator.substring(6);
            return getWebDriver().findElement(By.className(classLocator));
        } else {
            String xpath = locator.substring(6);
            return getWebDriver().findElement(By.xpath(xpath));
        }
    }
}
