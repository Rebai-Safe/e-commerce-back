package com.ecommerce.beans;

public class ProfileCredentials {
    private String firstName;
    private String lastName;
    private String email;
    private String country;

    public ProfileCredentials(String firstName, String lastName, String email, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
