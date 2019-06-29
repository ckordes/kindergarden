package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "group_table")
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;
    @ManyToMany//(fetch = FetchType.EAGER)
    private List<Child> childList;
    @NotBlank
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
}


/*
Group:
Nazwa
Dziecko (lista)
Opis grupy
Info (lista)
 */