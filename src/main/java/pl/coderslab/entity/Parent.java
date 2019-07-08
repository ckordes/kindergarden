package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validation.AdultValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull(groups = AdultValidation.class)
    private Person person;
    @NotBlank(groups = AdultValidation.class)
    private String companyName;
    private boolean guardian;
    private boolean allowedToPickUp;
    @ManyToMany//(fetch = FetchType.EAGER)
    private List<Child> childList;

    public Parent() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isGuardian() {
        return guardian;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public boolean isAllowedToPickUp() {
        return allowedToPickUp;
    }

    public void setAllowedToPickUp(boolean allowedToPickUp) {
        this.allowedToPickUp = allowedToPickUp;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName(){
        return this.person.getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Parent parent = (Parent) obj;
        return id == parent.id;
    }
}
