package com.crmproject.crm.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone1;
    private String phone2;
    private String telephone;

    private LocalDate birthday;

    private String businessId;

    // Constructors
    public CustomerDTO() {}

    public CustomerDTO(Long id, String name, String email, String phone1, String phone2, String telephone, LocalDate birthday, String businessId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.telephone = telephone;
        this.birthday = birthday;
        this.businessId = businessId;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getBusinessId() {
        return businessId;
    }
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }


    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", birthday='" + birthday + '\'' +
                ", businessId='" + businessId + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
