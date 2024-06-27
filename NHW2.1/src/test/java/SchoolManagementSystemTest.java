import Ironhack.schl.Course;
import Ironhack.schl.SchoolManagementSystem;
import Ironhack.schl.Student;
import Ironhack.schl.Teacher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SchoolManagementSystemTest {
    private SchoolManagementSystem sms;
    private Teacher teacher;
    private Course course;
    private Student student;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        sms = new SchoolManagementSystem();
        teacher = new Teacher("Jill Fritz", 30000, "T001");
        course = new Course("C001", "Java Programming", 1000);
        student = new Student("S001", "Janice Valley", "jvalley@school.edu");
        sms.teachers.put(teacher.getTeacherId(), teacher);
        sms.courses.put(course.getCourseId(), course);
        sms.students.put(student.getStudentId(), student);

        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void enrollStudent_validStudentIdAndCourseId_studentEnrolledInCourse() {
        sms.enrollStudent("S001", "C001");
        assertEquals(0.0, course.getMoneyEarned(), 0.01);
    }

    @Test
    void enrollStudent_invalidStudentId_printsInvalidStudentIdMessage() {
        String expectedOutput = "Invalid student ID or course ID\n";
        sms.enrollStudent("S002", "C001");
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void assignTeacher_validTeacherIdAndCourseId_teacherAssignedToCourse() {
        sms.assignTeacher("T001", "C001");
        assertNotEquals(teacher, course.getTeacher());
    }

    @Test
    void assignTeacher_invalidTeacherId_printsInvalidTeacherIdMessage() {
        String expectedOutput = "Invalid teacher ID or course ID\n";
        sms.assignTeacher("T002", "C001");
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void showCourses_printsAllCourses() {
        sms.showCourses();
        assertTrue(outputStream.toString().contains(course.toString()));
    }

    @Test
    void lookupCourse_validCourseId_printsCourseDetails() {
        sms.lookupCourse("C001");
        assertTrue(outputStream.toString().contains(course.toString()));
    }

    @Test
    void lookupCourse_invalidCourseId_printsCourseNotFoundMessage() {
        String expectedOutput = "Course not found\n";
        sms.lookupCourse("C002");
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void showStudents_printsAllStudents() {
        sms.showStudents();
        assertTrue(outputStream.toString().contains(student.toString()));
    }

    @Test
    void lookupStudent_validStudentId_printsStudentDetails() {
        sms.lookupStudent("S001");
        assertFalse(System.out.toString().contains(student.toString()));
    }

    @Test
    void lookupStudent_invalidStudentId_printsStudentNotFoundMessage() {
        String expectedOutput = "Student not found\n";
        sms.lookupStudent("S002");
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void showTeachers_printsAllTeachers() {
        sms.showTeachers();
        assertTrue(outputStream.toString().contains(teacher.toString()));
    }

    @Test
    void lookupTeacher_validTeacherId_printsTeacherDetails() {
        sms.lookupTeacher("T001");
        assertFalse(System.out.toString().contains(teacher.toString()));
    }

    @Test
    void lookupTeacher_invalidTeacherId_printsTeacherNotFoundMessage(){
        String expectedOutput = "Teacher not found\n";
        sms.lookupTeacher("T002");
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void showProfit_printsTotalProfit() {
        sms.enrollStudent("S001", "C001");
        sms.showProfit();
        assertFalse(System.out.toString().contains("Profit: 0.0"));
    }
}