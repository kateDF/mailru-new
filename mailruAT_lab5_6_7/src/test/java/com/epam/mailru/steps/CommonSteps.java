package com.epam.mailru.steps;

import com.epam.mailru.components.EmailFoldersList;
import com.epam.mailru.components.MailboxToolbar;
import com.epam.mailru.entity.Email;
import com.epam.mailru.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.time.LocalTime;

public class CommonSteps {

    private WebDriver driver;

    protected final Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        logger.info("Open mail.ru main page");
    }

    public void logIn(String username, String password) {
        logger.info("Log in with username: " + username + " password: " + password);
        MainPage mainPage = new MainPage(driver);
        mainPage.enterUsername(username);
        mainPage.enterPassword(password);
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();
    }

    public void logOut() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickLogOut();
        logger.info("Log out");
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
        logger.info("Create message with subject: "  + email.getSubject());
        CreateMessagePage createPage = new CreateMessagePage(driver);
        createPage.enterRecipient(email.getRecipientEmail());
        createPage.enterSubject(email.getSubject());
        createPage.enterTestMessage(email.getTextMessage());
    }

    public void saveAsDraft() {
        CreateMessagePage createPage = new CreateMessagePage(driver);
        createPage.saveEmailAsDraft();
        logger.info("Save message as a draft");
    }

    public String getSaveTime() {
        CreateMessagePage createPage = new CreateMessagePage(driver);
        return createPage.getTimeOfSaving();
    }

    public void openDrafts() {
        EmailFoldersList folderList = new EmailFoldersList(driver);
        folderList.goToDrafts();
        logger.info("Drafts opened");
    }

    public void sendMessage() {
        CreateMessagePage createPage = new CreateMessagePage(driver);
        createPage.clickSendButton();
        logger.info("Send message");
    }

    public void openSentEmailsPage() {
        EmailFoldersList folderList = new EmailFoldersList(driver);
        folderList.goToSentEmailsPage();
        logger.info("Sent emails opened");
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
        logger.info("Start searching by subject: " + subject);
        MailboxToolbar toolbar = new MailboxToolbar(driver);
        toolbar.enterSearchValue(subject);
        toolbar.clickSearchButton();
    }

    public boolean hasEmailSubjectInSearchResult(String subject) {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        return searchResultPage.hasInSearchResultBySubject(subject);
    }

    public void dragAndDropFromSentToArchive(Email email){
        SentEmailsPage sentEmails = new SentEmailsPage(driver);
        sentEmails.dragAndDropToArchive(email);
        logger.info("Drag-and-drop to archive");
    }
    public void openArchive(){
        EmailFoldersList folderList = new EmailFoldersList(driver);
        folderList.goToArchivePage();
        logger.info("Archive opened");
    }
    public boolean hasMessageInArchive(Email email) {
        ArchivePage archive = new ArchivePage(driver);
        return archive.hasInArchive(email);
    }

}
