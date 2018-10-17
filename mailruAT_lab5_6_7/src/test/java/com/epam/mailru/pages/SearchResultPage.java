package com.epam.mailru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends AbstractEmailsList {

    private static final By SEARCH_TICK_LOCATOR = By.xpath("div//span[@class='search_tick']");

    @FindBy(xpath = "//div[@id='b-search']//div[@class='b-datalist__body']//a")
    List<WebElement> searchResultsElements;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean hasInSearchResultBySubject(String subject) {
        for (WebElement result : searchResultsElements) {
            WebElement subjectAct = result.findElement(SEARCH_TICK_LOCATOR);
            if (subject.equals(subjectAct.getText())) {
                return true;
            }
        }
        return false;
    }

}
