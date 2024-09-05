package com.emazon.usermicroservice.domain.model;

import java.time.LocalDate;

public class User {

    private String name;

    private String lastName;

    private Long documentId;

    private String phoneNumber;

    private LocalDate birthDate;

    private String email;

    private String password;

    private Role role;

    public User(String name, String lastName, String phoneNumber, Long documentId, LocalDate birthDate, String email, String password, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.documentId = documentId;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
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

    public Role getRol() {
        return role;
    }

    public void setRol(Role role) {
        this.role = role;
    }
}