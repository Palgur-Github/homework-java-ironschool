package Ironhack.schl;

import java.util.UUID;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;
    private Course course = null;

    public Teacher(String name, double salary) {
        this.teacherId = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
        this.course = course;
    }

    public Teacher(String name, double salary, String teacherId) {
        this.teacherId = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
        this.course = course;
    }

    public void setCourse(String courseId) {
        this.course = course;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}