package pl.coderslab.entity;

import pl.coderslab.validation.AdultValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne//(cascade = {CascadeType.MERGE,CascadeType.REMOVE})//(fetch = FetchType.EAGER)
    @NotNull(groups = AdultValidation.class)
    private Person person;

    public Teacher() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

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