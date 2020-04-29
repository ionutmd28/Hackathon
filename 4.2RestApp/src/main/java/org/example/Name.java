package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
@XmlAccessorType()
public class Name {
    private String firstName;

    private String lastName;

    private String fullName;

    @XmlElement(name = "MyFirstName")
    public String getFirstName() {
        return firstName;
    }

    @XmlElement(defaultValue = "Hategan")
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
