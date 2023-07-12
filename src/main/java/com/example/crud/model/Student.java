package com.example.crud.model;
import javax.persistence.*;

@Entity
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;

    @Column(
            name = "name",
            columnDefinition = "TEXT",
            nullable = false,
            updatable = true
    )
    private String name;

    @Column(
            name = "email",
            columnDefinition = "TEXT",
            unique = true,
            nullable = false,
            updatable = false,
            length = 100
    )
    private String email;

    @Column(
            name = "dept",
            columnDefinition = "TEXT",
            nullable = false,
            updatable = true,
            length = 50
    )
    private String dept;

    public Student(Integer id, String name, String email, String dept) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    public Student() {
    }
}
