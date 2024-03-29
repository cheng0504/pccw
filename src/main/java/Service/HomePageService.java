package Service;

import PO.HomePageObject;

import java.io.IOException;

public class HomePageService {

    HomePageObject homePageObject = new HomePageObject();
    public void openHomePage(){
        homePageObject.openUrl();
    }

    public void uploadPicture()  {
        homePageObject.searchByImage().click();
        String path = null;
        String currentDirectory = System.getProperty("user.dir");
        path =  currentDirectory + "/src/main/resources/" + ConfigService.getSourceFileName();
        homePageObject.selectPicture().sendKeys(path);

    }
}
