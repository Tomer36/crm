package com.crmproject.crm.dto;

import java.time.LocalDateTime;

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone1;
    private String phone2;
    private String telephone;
    private LocalDateTime birthDate;

    // Constructors
    public CustomerDTO() {}

    public CustomerDTO(Long id, String name, String email, String phone1, String phone2, String telephone, LocalDateTime birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.telephone = telephone;
        this.birthDate = birthDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
