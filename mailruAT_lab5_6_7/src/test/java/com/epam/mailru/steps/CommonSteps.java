package com.epam.mailru.steps;

import com.epam.mailru.components.EmailFoldersList;
import com.epam.mailru.entity.Email;
import com.epam.mailru.pages.*;
import org.openqa.selenium.WebDriver;

import java.time.LocalTime;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        return mainPage;
    }

    public EmailMainPage logIn(String username, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.enterUsername(username);
        mainPage.enterPassword(password);
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();
        return new EmailMainPage(driver);
    }

    public MainPage logOut() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickLogOut();
        return new MainPage(driver);
    }

    public String getCurrentUser() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        return emailMainPage.getCurrentUserEmail();
    }

    public CreateMessagePage clickCreateMessage() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickCreateMessage();
        return new CreateMessagePage(driver);
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

    public DraftsPage openDrafts() {
        EmailFoldersList folderList = new EmailFoldersList(driver);
        return folderList.goToDrafts();
    }

    public ConfirmationPage sendMessage(){
        CreateMessagePage createPage = new CreateMessagePage(driver);
        createPage.clickSendButton();
        return new ConfirmationPage(driver);
    }

    public SentEmailsPage openSentEmailsPage() {
        EmailFoldersList folderList = new EmailFoldersList(driver);
        return folderList.goToSentEmailsPage();
    }

    public void saveTimeOfSending(Email email){
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

    public boolean checkLogOut(){
        MainPage mainPage = new MainPage(driver);
        return mainPage.checkLogOut();
    }

}
