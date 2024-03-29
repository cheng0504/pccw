package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePageObject extends PageObject{

    public HomePageObject(){
        super();
    }

    public void openUrl(){
        webDriver.get("https://www.baidu.com/");
    }
    public WebElement searchByImage(){
        return webDriver.findElement(By.cssSelector(".soutu-btn"));
    }

    public WebElement selectPicture(){
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return webDriver.findElement(By.cssSelector("input[type=\"file\"]"));
    }

}
