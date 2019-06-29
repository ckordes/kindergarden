package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne//(fetch = FetchType.EAGER)
    @NotNull
    private Person person;

//    @ManyToMany//(fetch = FetchType.EAGER)
//    private List<Group> groupList;

    public Teacher() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
//
//    public List<Group> getGroupList() {
//        return groupList;
//    }
//
//    public void setGroupList(List<Group> groupList) {
//        this.groupList = groupList;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName(){
        return this.person.getFirstName()+" "+this.person.getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/*
Teacher:
Pesel
Numer dowodu
Imie
Drugie Imie
Nazwisko
Adres zamieszkania
Grupa (lista)
 */