package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.validation.AdultValidation;
import pl.coderslab.validation.ChildValidation;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private boolean homeWork;
    @NotBlank(groups = {ChildValidation.class, AdultValidation.class})
    private String street;
    @NotBlank(groups = {ChildValidation.class, AdultValidation.class})
    private String numberBuilding;
    private String numberFlat;
//    @Pattern(regexp="\\d{5}")
    private int zipCode;
    @NotBlank(groups = {ChildValidation.class, AdultValidation.class})
    private String city;
    @NotBlank(groups = {ChildValidation.class, AdultValidation.class})
    private String voievodyship;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberBuilding() {
        return numberBuilding;
    }

    public void setNumberBuilding(String numberBuilding) {
        this.numberBuilding = numberBuilding;
    }

    public String getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(String numberFlat) {
        this.numberFlat = numberFlat;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVoievodyship() {
        return voievodyship;
    }

    public void setVoievodyship(String voievodyship) {
        this.voievodyship = voievodyship;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isHomeWork() {
        return homeWork;
    }

    public void setHomeWork(boolean homeWork) {
        this.homeWork = homeWork;
    }

    public Address(boolean homeWork, String street, String numberBuilding, String numberFlat, int zipCode, String city, String voievodyship) {
        this.homeWork = homeWork;
        this.street = street;
        this.numberBuilding = numberBuilding;
        this.numberFlat = numberFlat;
        this.zipCode = zipCode;
        this.city = city;
        this.voievodyship = voievodyship;
    }
}
