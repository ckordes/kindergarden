package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String pesel;
    @NotBlank
    private String firstName;
    private String secondName;
    @NotBlank
    private String lastName;

    private String idNumber;

    @OneToOne //( cascade = {CascadeType.ALL})
    private Address homeAddress;
    @OneToOne //( cascade = {CascadeType.ALL})
    private Address workAddress;

//    @NotBlank
//    @Email
    private String email;
//    @NotBlank
    private String password;


    public Person() {
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName(){
        return this.getFirstName() +" "+this.getLastName();
    }
}

/*
Parent:
Pesel
Numer dowodu
Imie
Drugie Imie
Nazwisko
Adres zamieszkania
Zaklad pracy
Telefon kontaktowy (lista)
Email
Rodzic/opiekun (true/false)
Dziecko (lista)
Allowed (czy moze odebrac z przedszkola czy nie)
 */