package org.example;
import Service.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){
        HomePageService homePageService = new HomePageService();
        SearchResultService searchResultService = new SearchResultService();

        //open www.baidu.com
        homePageService.openHomePage();
        //use source image and launch "search by image"
        homePageService.uploadPicture();
        //choose the number x result and click it
        searchResultService.selectTargetResult(ConfigService.getIndex());
        //capture the snapshot of newly opened tab
        WebDriverService.caputureScreenShot();
        //close chrome
        WebDriverService.closeDriver();
        //compare the source image and the snapshot, and output the similarity percentage
        ConfigService.imageComparison();

    }
}