package com.epam.mailru.entity;

public class Email {

    private String recipientEmail;
    private String subject;
    private String textMessage;
    private String timeOfSaving;
    private String timeOfSending;
    private boolean deliveryNotification;

    public Email() {
    }

    public Email(String recipientEmail, String subject, String textMessage) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.textMessage = textMessage;
    }

    public Email(String recipientEmail, String subject, String textMessage, String timeOfSending) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.textMessage = textMessage;
        this.timeOfSending = timeOfSending;
    }

    public Email(String recepientEmail, String subject, String textMessage, String timeOfSending, boolean deliveryNotification) {
        this.recipientEmail = recepientEmail;
        this.subject = subject;
        this.textMessage = textMessage;
        this.timeOfSending = timeOfSending;
        this.deliveryNotification = deliveryNotification;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTimeOfSending() {
        return timeOfSending;
    }

    public void setTimeOfSending(String timeOfSending) {
        this.timeOfSending = timeOfSending;
    }

    public String getTimeOfSaving() {
        return timeOfSaving;
    }

    public void setTimeOfSaving(String timeOfSaving) {
        this.timeOfSaving = timeOfSaving;
    }

    public boolean isDeliveryNotification() {
        return deliveryNotification;
    }

    public void setDeliveryNotification(boolean deliveryNotification) {
        this.deliveryNotification = deliveryNotification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (deliveryNotification != email.deliveryNotification) return false;
        if (recipientEmail != null ? !recipientEmail.equals(email.recipientEmail) : email.recipientEmail != null)
            return false;
        if (subject != null ? !subject.equals(email.subject) : email.subject != null) return false;
        if (textMessage != null ? !textMessage.equals(email.textMessage) : email.textMessage != null) return false;
        if (timeOfSaving != null ? !timeOfSaving.equals(email.timeOfSaving) : email.timeOfSaving != null) return false;
        return timeOfSending != null ? timeOfSending.equals(email.timeOfSending) : email.timeOfSending == null;
    }

    @Override
    public int hashCode() {
        int result = recipientEmail != null ? recipientEmail.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (textMessage != null ? textMessage.hashCode() : 0);
        result = 31 * result + (timeOfSaving != null ? timeOfSaving.hashCode() : 0);
        result = 31 * result + (timeOfSending != null ? timeOfSending.hashCode() : 0);
        result = 31 * result + (deliveryNotification ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "recipientEmail='" + recipientEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", textMessage='" + textMessage + '\'' +
                ", timeOfSaving='" + timeOfSaving + '\'' +
                ", timeOfSending='" + timeOfSending + '\'' +
                ", deliveryNotification=" + deliveryNotification +
                '}';
    }

}
