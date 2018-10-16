package com.epam.mailru.components;

import com.epam.mailru.pages.DraftsPage;
import com.epam.mailru.pages.SentEmailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailFoldersList extends AbstractComponent {

    @FindBy(xpath = "//div[@data-id='500000']/a")
    private WebElement sentEmailsPageButton;

    @FindBy(xpath = "//div[@data-id='500001']/a")
    private WebElement draftsPageButton;

    private WebDriver driver;

    public EmailFoldersList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DraftsPage goToDrafts() {
        waitElementRefresh(draftsPageButton);
        draftsPageButton.click();
        return new DraftsPage(driver);
    }

    public SentEmailsPage goToSentEmailsPage() {
        waitForClicableAndClick(sentEmailsPageButton);
        waitForDocumentReady();
        return new SentEmailsPage(driver);
    }

}
