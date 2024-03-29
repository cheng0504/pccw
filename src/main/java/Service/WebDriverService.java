package Service;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class WebDriverService {

    static WebDriver webDriver;

    public static WebDriver getDriver(){
        if(webDriver == null){
            webDriver = getWebDriverInstance();
        }
        return webDriver;
    }
    private static WebDriver getWebDriverInstance(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        WebDriver webDriver = new ChromeDriver(options);
        return webDriver;
    }
    public static void closeDriver(){
        webDriver.quit();
    }

    public static void caputureScreenShot(){

        //get all the tab handels
        Set<String> windowHandles = webDriver.getWindowHandles();

        String lastTabHandle = (String) windowHandles.toArray()[windowHandles.size() - 1];
        //switch to the last tab
        webDriver.switchTo().window(lastTabHandle);
        //save the screenshot
        File screenshotFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("src/main/resources/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
