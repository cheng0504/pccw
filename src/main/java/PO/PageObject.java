package PO;

import Service.WebDriverService;
import org.openqa.selenium.WebDriver;

public class PageObject {

    protected WebDriver webDriver;

    public PageObject(){
        this.webDriver = WebDriverService.getDriver();

    }
}
