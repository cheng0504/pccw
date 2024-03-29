package Service;

import java.util.List;
import PO.SearchResultPageObject;
import org.openqa.selenium.WebElement;

public class SearchResultService {

    SearchResultPageObject searchResultPageObject = new SearchResultPageObject();

    public void selectTargetResult(String target){
        int number = Integer.valueOf(target).intValue() - 1;
        List<WebElement> lists = searchResultPageObject.graphSameItems();
        int size = lists.size();
        lists.get(number % size).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


}
