package Ironhack.schl;

import java.util.UUID;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course = null;

// Constructor

    public Student(String name, String address, String email) {
        this.studentId = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = course;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }


    // Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Other Methods
    public void showStudent(Student student)
    {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
    }

    public void lookupStudent(String studentId) {
        if (studentId.equals(this.studentId)) {
            System.out.println("Student ID: " + studentId);
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Email: " + email);
        } else {
            System.out.println("Student ID not found");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", course=" + (course != null ? course.getName() : "None") +
                '}';
    }
}