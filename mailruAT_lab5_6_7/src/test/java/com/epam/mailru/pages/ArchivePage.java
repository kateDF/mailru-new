package com.epam.mailru.pages;

import com.epam.mailru.entity.Email;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ArchivePage extends AbstractEmailsList {

    @FindBy(xpath = "//div[@id='b-letters']//a[contains(@class, 'b-datalist__item__link')]")
    List<WebElement> archiveEmailsElements;

    public ArchivePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean hasInArchive(Email email) {
        driver.navigate().refresh();
        for (WebElement message : archiveEmailsElements) {
            WebElement subjectAct = message.findElement(SUBJECT_IN_ELEMENT);
            if (subjectAct == null & email.getSubject() == null
                    || subjectAct.getText().contains(email.getSubject())) {
                return true;
            }
        }
        return false;
    }

}
