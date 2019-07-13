package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.validation.AdultValidation;
import pl.coderslab.validation.ChildValidation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChildRelatedMessages {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(groups = {AdultValidation.class, ChildValidation.class})
    private String message;

    @ManyToOne//(fetch = FetchType.EAGER)
    private Child child;

    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public ChildRelatedMessages() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
