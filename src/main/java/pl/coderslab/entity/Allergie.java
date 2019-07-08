package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.validation.ChildValidation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Allergie {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "child_alergies", joinColumns = @JoinColumn(name = "allergie_id")
            , inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> childList;
    @NotBlank (groups = ChildValidation.class)
    private String typeOfAllergie;

    public Allergie() {
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public String getTypeOfAllergie() {
        return typeOfAllergie;
    }

    public void setTypeOfAllergie(String typeOfAllergie) {
        this.typeOfAllergie = typeOfAllergie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
