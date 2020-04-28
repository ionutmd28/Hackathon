package org.example;

public class Name {
    private String firstName;
    private String lastName;
    private String fullName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }
}
