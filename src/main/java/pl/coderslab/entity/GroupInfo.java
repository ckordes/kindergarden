package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.validation.AdultValidation;
import pl.coderslab.validation.ChildValidation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class GroupInfo {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank (groups = {AdultValidation.class, ChildValidation.class})
    private String message;

    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public GroupInfo() {
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
