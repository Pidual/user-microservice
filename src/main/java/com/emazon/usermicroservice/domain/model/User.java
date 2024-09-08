package com.emazon.usermicroservice.domain.model;


import java.time.LocalDate;

public class User {

    private String firstName;

    private String lastName;

    private String documentId;

    private String phoneNumber;

    private LocalDate birthDate;

    private String email;

    private String password;

    private RoleEnum role;

    public User(String firstName, String lastName, String phoneNumber, String documentId, LocalDate birthDate, String email, String password, RoleEnum role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.documentId = documentId;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRol() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}