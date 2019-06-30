package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Child {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Person person;
    @ManyToMany(mappedBy = "childList")//,fetch = FetchType.EAGER
    private List<Parent> parentList;
    @NotEmpty
    @ManyToMany(mappedBy = "childList",cascade = CascadeType.MERGE)//,fetch = FetchType.EAGER
    private List<Group> groupList;
    @OneToMany(mappedBy = "child")//,fetch = FetchType.EAGER)
    private List<Payment> paymentList;
    @OneToMany (mappedBy = "child")//,fetch = FetchType.EAGER)
    private List<ChildRelatedMessages> childRelatedMessagesList;
    @ManyToMany(mappedBy = "childList")//,fetch = FetchType.EAGER)
    private List<Allergie> allergieList;
    @OneToMany(mappedBy = "child")//,fetch = FetchType.EAGER)
    private List<InfoForTeacher> infoForTeachers;
//    @NotBlank
    private double startHour;
//    @NotBlank
    private double endHour;

    public Child() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<ChildRelatedMessages> getChildRelatedMessagesList() {
        return childRelatedMessagesList;
    }

    public void setChildRelatedMessagesList(List<ChildRelatedMessages> childRelatedMessagesList) {
        this.childRelatedMessagesList = childRelatedMessagesList;
    }

    public List<Allergie> getAllergieList() {
        return allergieList;
    }

    public void setAllergieList(List<Allergie> allergieList) {
        this.allergieList = allergieList;
    }

    public List<InfoForTeacher> getInfoForTeachers() {
        return infoForTeachers;
    }

    public void setInfoForTeachers(List<InfoForTeacher> infoForTeachers) {
        this.infoForTeachers = infoForTeachers;
    }

    public double getStartHour() {
        return startHour;
    }

    public void setStartHour(double startHour) {
        this.startHour = startHour;
    }

    public double getEndHour() {
        return endHour;
    }

    public void setEndHour(double endHour) {
        this.endHour = endHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName(){
        return person.getFirstName() + " "+ person.getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return id == child.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/*
Child:
Pesel
Imie
Drugie Imie
Nazwisko
Adres zamieszkania
Rodzic/opiekun (lista)
Grupa (lista)
Payments(lista)
ChildRelatedMessages(lista)
Allergie (lista)
infoForTeacher (lista)
Start (kiedy przyprowadzane – deklaracja)
End (kiedy odbierane – deklaracja)
 */