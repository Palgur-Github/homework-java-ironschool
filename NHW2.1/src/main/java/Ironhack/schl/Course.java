package Ironhack.schl;

import java.util.UUID;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;


    // New constructor
    public Course(String courseId, String name, double price) {
        this.courseId = courseId;
        this.name = name;
        this.price = price;
        this.moneyEarned = 0.0; // Initialize moneyEarned to 0
    }

    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString();
        this.price = price;
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", moneyEarned=" + moneyEarned +
                ", teacher=" + teacher +
                '}';
    }
}
