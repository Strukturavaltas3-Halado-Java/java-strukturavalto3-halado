package org.training360.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    void init() {
        student = new Student("John Doe", LocalDate.of(2023, 3, 3));
        student.addGradeWithSubject("mathematics", 5);
        student.addGradeWithSubject("physics", 4);
        student.addGradeWithSubject("mathematics", 3);
    }

    @Test
    void testAddGradeWithSubject() {
        assertEquals(2, student.getSubjectAndGrades().size());
        assertEquals(1, student.getSubjectAndGrades().get("physics").size());
        assertThat(student.getSubjectAndGrades().get("mathematics"))
                .hasSize(2)
                .containsExactly(5, 3);
    }

    @Test
    void testAddGradeWithSubjectNoGradesBefore() {
        Student student = new Student("Jack Doe", LocalDate.of(2023, 3, 3));
        student.addGradeWithSubject("mathematics", 5);

        assertEquals(1, student.getSubjectAndGrades().size());
        assertEquals(1, student.getSubjectAndGrades().get("mathematics").size());
        assertEquals(5, student.getSubjectAndGrades().get("mathematics").get(0));
    }

    @Test
    void testCountNumberOfGrades() {
        assertEquals(3, student.countNumberOfGrades());
    }
}