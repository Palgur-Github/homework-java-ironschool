package Ironhack.schl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the name of the school
        System.out.print("Enter the name of the school: ");
        String schoolName = scanner.nextLine();

        // Create the SchoolManagementSystem instance
        SchoolManagementSystem sms = new SchoolManagementSystem();

        // Prompt the user for the number of teachers, courses, and students
        System.out.print("Enter the number of teachers: ");
        int numTeachers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        // Collect and store teacher details
        for (int i = 0; i < numTeachers; i++) {
            System.out.println("Enter teacher details for Teacher " + (i + 1));
            System.out.print("Name: ");
            String teacherName = scanner.nextLine();

            Teacher teacher = new Teacher(teacherName, 60000);
            sms.teachers.put(Integer.toString(i + 1), teacher);
        }

        // Collect and store course details
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter course details for Course " + (i + 1));
            System.out.print("Name: ");
            String courseName = scanner.nextLine();

            Course course = new Course(courseName, 1000);
            sms.courses.put(Integer.toString(i + 1), course);
        }

        // Collect and store student details
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student details for Student " + (i + 1));
            System.out.print("Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Address: ");
            String studentAddress = scanner.nextLine();
            System.out.print("Email: ");
            String studentEmail = scanner.nextLine();

            Student student = new Student(studentName, studentAddress, studentEmail);
            sms.students.put(Integer.toString(i + 1), student);
        }

        // Main loop to handle commands
        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            try {
                switch (parts[0]) {
                    case "ENROLL":
                        sms.enrollStudent(parts[1], parts[2]);
                        break;
                    case "ASSIGN":
                        sms.assignTeacher(parts[1], parts[2]);
                        break;
                    case "SHOW":
                        if (parts[1].equals("COURSES")) {
                            sms.showCourses();
                        } else if (parts[1].equals("STUDENTS")) {
                            sms.showStudents();
                        } else if (parts[1].equals("TEACHERS")) {
                            sms.showTeachers();
                        } else if (parts[1].equals("PROFIT")) {
                            sms.showProfit();
                        }
                        break;
                    case "LOOKUP":
                        if (parts[1].equals("COURSE")) {
                            sms.lookupCourse(parts[2]);
                        } else if (parts[1].equals("STUDENT")) {
                            sms.lookupStudent(parts[2]);
                        } else if (parts[1].equals("TEACHER")) {
                            sms.lookupTeacher(parts[2]);
                        }
                        break;
                    default:
                        System.out.println("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
        }
    }
}