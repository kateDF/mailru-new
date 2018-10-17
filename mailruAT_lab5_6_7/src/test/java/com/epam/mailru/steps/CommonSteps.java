package com.epam.mailru.steps;

import com.epam.mailru.components.EmailFoldersList;
import com.epam.mailru.components.MailboxToolbar;
import com.epam.mailru.entity.Email;
import com.epam.mailru.pages.*;
import org.openqa.selenium.WebDriver;

import java.time.LocalTime;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    public void logIn(String username, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.enterUsername(username);
        mainPage.enterPassword(password);
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();
    }

    public void logOut() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickLogOut();
    }

    public String getCurrentUser() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        return emailMainPage.getCurrentUserEmail();
    }

    public void clickCreateMessage() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickCreateMessage();
    }

    public void createMessage(Email email) {
        CreateMessagePage createPage = new CreateMessagePage(driver);
        createPage.createMessage(email);
    }

    public void saveAsDraft() {
        CreateMessagePage createPage = new CreateMessagePage(driver);
        createPage.saveEmailAsDraft();
    }

    public String getSaveTime() {
        CreateMessagePage createPage = new CreateMessagePage(driver);
        return createPage.getTimeOfSaving();
    }

    public void openDrafts() {
        EmailFoldersList folderList = new EmailFoldersList(driver);
        folderList.goToDrafts();
    }

    public void sendMessage() {
        CreateMessagePage createPage = new CreateMessagePage(driver);
        createPage.clickSendButton();
    }

    public void openSentEmailsPage() {
        EmailFoldersList folderList = new EmailFoldersList(driver);
        folderList.goToSentEmailsPage();
    }

    public void saveTimeOfSending(Email email) {
        LocalTime time = LocalTime.now();
        email.setTime(time.toString().substring(0, 5));
    }

    public boolean openMessageFromDrafts(Email email) {
        DraftsPage draftsPage = new DraftsPage(driver);
        return draftsPage.openMessageFromEmailList(email);
    }

    public boolean hasMessageInDrafts(Email email) {
        DraftsPage draftsPage = new DraftsPage(driver);
        return draftsPage.hasInList(email);
    }

    public boolean hasMessageInSentEmails(Email email) {
        SentEmailsPage sentEmails = new SentEmailsPage(driver);
        return sentEmails.hasInList(email);
    }

    public boolean checkLogOut() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.checkLogOut();
    }

    public void searchBySubject(String subject){
        MailboxToolbar toolbar = new MailboxToolbar(driver);
        toolbar.enterSearchValue(subject);
        toolbar.clickSearchButton();
    }

    public boolean hasEmailSubjectInSearchResult(String subject) {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        return searchResultPage.hasInSearchResultBySubject(subject);
    }

}
