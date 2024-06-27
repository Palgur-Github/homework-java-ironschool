package Ironhack.schl;

import java.util.*;

public class SchoolManagementSystem {
    public Map<String, Teacher> teachers;
    public Map<String, Course> courses;
    public Map<String, Student> students;

    public SchoolManagementSystem() {
        teachers = new HashMap<>();
        courses = new HashMap<>();
        students = new HashMap<>();
    }

    public void enrollStudent(String studentId, String courseId) throws Exception{
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student != null && course != null) {
            student.setCourse(course);
            course.setMoneyEarned(course.getMoneyEarned() + course.getPrice());
        } else {
            System.out.println("Invalid student ID or course ID");
        }
    }

    public void assignTeacher(String teacherId, String courseId) throws Exception {
        Teacher teacher = teachers.get(teacherId);
        Course course = courses.get(courseId);
        if (teacher != null && course != null) {
            course.setTeacher(teacher);
        } else {
            System.out.println("Invalid teacher ID or course ID");
        }
    }

    public void showCourses() {
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    public void lookupCourse(String courseId) throws Exception {
        Course course = courses.get(courseId);
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("Course not found");
        }
    }

    public void showStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    public void lookupStudent(String studentId) throws Exception{
        Student student = students.get(studentId);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    public void showTeachers() {
        for (Teacher teacher : teachers.values()) {
            System.out.println(teacher);
        }
    }

    public void lookupTeacher(String teacherId) throws Exception {
        Teacher teacher = teachers.get(teacherId);
        if (teacher != null) {
            System.out.println(teacher);
        } else {
            System.out.println("Teacher not found");
        }
    }

    public void showProfit() {
        double totalMoneyEarned = courses.values().stream().mapToDouble(Course::getMoneyEarned).sum();
        double totalSalaries = teachers.values().stream().mapToDouble(Teacher::getSalary).sum();
        System.out.println("Profit: " + (totalMoneyEarned - totalSalaries));
    }
}