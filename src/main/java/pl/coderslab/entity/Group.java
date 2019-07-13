package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validation.AdultValidation;
import pl.coderslab.validation.ChildValidation;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "group_table")
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank //(groups = {AdultValidation.class, ChildValidation.class})
    private String name;
    @ManyToMany//(fetch = FetchType.EAGER)
    private List<Child> childList;
    @NotBlank//
    private String description;
    @OneToMany//(fetch = FetchType.EAGER)
    private List<GroupInfo> groupInfoList;
    @ManyToMany
    private List<Teacher> teacherList;

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GroupInfo> getGroupInfoList() {
        return groupInfoList;
    }

    public void setGroupInfoList(List<GroupInfo> groupInfoList) {
        this.groupInfoList = groupInfoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, childList, description, groupInfoList, teacherList);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", groupInfoList=" + groupInfoList +
                ", teacherList=" + teacherList +
                '}';
    }
}
