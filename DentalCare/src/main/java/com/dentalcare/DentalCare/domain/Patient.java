package com.dentalcare.DentalCare.domain;

import java.util.Date;

public class Patient {
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private Integer dni;
    private Date dischargeDate;

    //constructors

    public Patient(Long id, String name, String lastname, String address, Integer dni, Date dischargeDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.dni = dni;
        this.dischargeDate = dischargeDate;
    }
    public Patient(String name, String lastname, String address, Integer dni, Date dischargeDate) {

        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.dni = dni;
        this.dischargeDate = dischargeDate;
    }

    public Patient() {

    }


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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", dni='" + dni + '\'' +
                ", dischargeDate='" + dischargeDate.toString() + '\'' +
                '}';
    }
}
