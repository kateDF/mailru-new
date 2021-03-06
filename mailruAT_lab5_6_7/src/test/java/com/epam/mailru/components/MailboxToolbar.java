package com.epam.mailru.components;

import com.epam.mailru.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailboxToolbar extends AbstractComponent {

    @FindBy(xpath = "//input[contains(@class,'pm-toolbar__search__input')]")
    private WebElement searchingField;

    @FindBy(xpath = "//button[@name='search']")
    private WebElement searchButton;

    public MailboxToolbar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterSearchValue(String subject) {
        driver.navigate().refresh();
        searchingField.sendKeys(subject);
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage(driver);
    }

}
