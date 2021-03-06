package com.epam.mailru.entity;

public class Email {

    private String recipientEmail; // required
    private String subject; // required
    private String textMessage; // required
    private String time; // optional
    private boolean deliveryNotification; // optional


    private Email(EmailBuilder builder) {
        this.recipientEmail = builder.recipientEmail;
        this.subject = builder.subject;
        this.textMessage = builder.textMessage;
        this.time = builder.time;
        this.deliveryNotification = builder.deliveryNotification;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        return time != null ? time.equals(email.time) : email.time == null;
    }

    @Override
    public int hashCode() {
        int result = recipientEmail != null ? recipientEmail.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (textMessage != null ? textMessage.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (deliveryNotification ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "recipientEmail='" + recipientEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", textMessage='" + textMessage + '\'' +
                ", time='" + time + '\'' +
                ", deliveryNotification=" + deliveryNotification +
                '}';
    }

    public static class EmailBuilder {
        private String recipientEmail;
        private String subject;
        private String textMessage;
        private String time;
        private boolean deliveryNotification;

        public EmailBuilder(String recipientEmail, String subject, String textMessage) {
            this.recipientEmail = recipientEmail;
            this.subject = subject;
            this.textMessage = textMessage;
        }

        public EmailBuilder time(String time) {
            this.time = time;
            return this;
        }

        public EmailBuilder deliveruNotification(boolean deliveryNotification) {
            this.deliveryNotification = deliveryNotification;
            return this;
        }

        public Email build() {
            Email email = new Email(this);
            return email;
        }

    }

}