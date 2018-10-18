package com.epam.mailru.components;

import com.epam.mailru.pages.ArchivePage;
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

    @FindBy(xpath = "//div[@data-id='500010']/a")
    private WebElement archivePageButton;

    public EmailFoldersList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DraftsPage goToDrafts() {
        safeClick(draftsPageButton);
        return new DraftsPage(driver);
    }

    public SentEmailsPage goToSentEmailsPage() {
        safeClick(sentEmailsPageButton);
        return new SentEmailsPage(driver);
    }

    public ArchivePage goToArchivePage() {
        safeClick(archivePageButton);
        return new ArchivePage(driver);
    }

}
