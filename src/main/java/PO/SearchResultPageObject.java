package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResultPageObject extends PageObject{

    public SearchResultPageObject(){
        super();
    }

    public List<WebElement> graphSameItems(){
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return webDriver.findElements(By.cssSelector(".graph-same-list .graph-same-item a"));
    }


}
