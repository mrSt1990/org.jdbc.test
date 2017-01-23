package org.data.subject;

import java.util.Date;

/**
 * Created by mr_St on 19.01.17.
 */
public class Letter extends Entity {
    private int idSender;
    private int idRecipient;
    private String subject;
    private String text;
    private Date sendDate;

    public Letter() {
    }

    public Letter(int id, int idSender, int idRecipient, String subject, String text, Date sendDate) {
        super(id);
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.subject = subject;
        this.text = text;
        this.sendDate = sendDate;
    }

    public int getSender() {
        return idSender;
    }

    public void setSender(int idSender) {
        this.idSender = idSender;
    }

    public int getRecipient() {
        return idRecipient;
    }

    public void setRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "sender=" + idSender +
                ", recipient=" + idRecipient +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", sendDate=" + sendDate +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter = (Letter) o;

        if (idSender != letter.idSender) return false;
        if (idRecipient != letter.idRecipient) return false;
        if (subject != null ? !subject.equals(letter.subject) : letter.subject != null) return false;
        if (text != null ? !text.equals(letter.text) : letter.text != null) return false;
        return sendDate != null ? sendDate.equals(letter.sendDate) : letter.sendDate == null;
    }

    @Override
    public int hashCode() {
        int result = idSender;
        result = 31 * result + idRecipient;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        return result;
    }

    @Override
    public Letter clone() {
        Letter copy = null;
        try{
            copy = (Letter)super.clone();
            copy.sendDate = (Date)sendDate.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return copy;
    }
}
