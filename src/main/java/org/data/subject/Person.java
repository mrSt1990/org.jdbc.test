package org.data.subject;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr_St on 19.01.17.
 */
public class Person extends Entity {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date dateOfBirth;

    private Set<Letter> sendLetters = new HashSet<Letter>();
    private Set<Letter> recieveLetters = new HashSet<Letter>();

    public Person() {
    }

    public Person(int id, String lastName, String firstName, String middleName, Date dateOfBirth) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Letter> getSendLetters() {
        return sendLetters;
    }

    public void setSendLetters(Set<Letter> sendLetters) {
        this.sendLetters = sendLetters;
    }

    public Set<Letter> getRecieveLetters() {
        return recieveLetters;
    }

    public void setRecieveLetters(Set<Letter> recieveLetters) {
        this.recieveLetters = recieveLetters;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (middleName != null ? !middleName.equals(person.middleName) : person.middleName != null) return false;
        return dateOfBirth != null ? dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @Override
    public Person clone() {
        Person copy = null;
        try {
            copy = (Person)super.clone();
            copy.dateOfBirth = (Date)dateOfBirth.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return copy;
    }
}
