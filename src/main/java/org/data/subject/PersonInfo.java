package org.data.subject;

/**
 * Created by mr_St on 22.01.17.
 */
public class PersonInfo {
    private Person person;
    private int sendLettersCnt;
    private int recieveLetterCnt;

    public PersonInfo() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getSendLettersCnt() {
        return sendLettersCnt;
    }

    public void setSendLettersCnt(int sendLettersCnt) {
        this.sendLettersCnt = sendLettersCnt;
    }

    public int getRecieveLetterCnt() {
        return recieveLetterCnt;
    }

    public void setRecieveLetterCnt(int recieveLetterCnt) {
        this.recieveLetterCnt = recieveLetterCnt;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "person=" + person +
                ", sendLettersCnt=" + sendLettersCnt +
                ", recieveLetterCnt=" + recieveLetterCnt +
                '}';
    }
}
