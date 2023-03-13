package org.training360.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository repository;

    @InjectMocks
    StudentService service;

    Student student;

    @BeforeEach
    void init() {
        student = new Student("John Doe", LocalDate.of(2023, 3, 3));
        student.addGradeWithSubject("mathematics", 5);
        student.addGradeWithSubject("physics", 4);
        student.addGradeWithSubject("mathematics", 3);
    }

    @Test
    void testSaveNewStudent() {
        when(repository.saveNewStudent(student)).thenReturn(new Student("Jack Doe", LocalDate.of(2022, 2, 2)));

        Student expected = service.saveNewStudent(student);

        assertEquals("Jack Doe", expected.getName());
        assertEquals(LocalDate.of(2022, 2, 2), expected.getDateOfBirth());
        assertEquals(0, expected.getSubjectAndGrades().size());
    }

    @Test
    void testCalculateStudentAverageBySubject() {
        when(repository.findStudentByName(any())).thenReturn(Optional.of(student));

        assertEquals(4, service.calculateStudentAverageBySubject("John Doe", "mathematics"));
    }

    @Test
    void testCalculateStudentAverageBySubjectNoSuchStudent() {
        when(repository.findStudentByName(any())).thenReturn(Optional.empty());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.calculateStudentAverageBySubject("Jack Doe", "mathematics"));
        assertEquals("Cannot find student with this name: Jack Doe", ex.getMessage());
    }

    @Test
    void testFindStudentsWithMoreGradesThan() {
        Student jack = new Student("Jack Doe", LocalDate.of(2023, 3, 3));
        jack.addGradeWithSubject("mathematics", 5);
        Student jane = new Student("Jane Doe", LocalDate.of(2023, 3, 3));
        jane.addGradeWithSubject("mathematics", 5);
        jane.addGradeWithSubject("physics", 4);
        jane.addGradeWithSubject("mathematics", 3);
        Student jonathan = new Student("Jonathan Doe", LocalDate.of(2023, 3, 3));
        jonathan.addGradeWithSubject("mathematics", 5);
        jonathan.addGradeWithSubject("physics", 4);
        jonathan.addGradeWithSubject("physics", 2);
        jonathan.addGradeWithSubject("mathematics", 3);
        List<Student> students = List.of(student, jack, jane, jonathan);

        when(repository.findAllStudents()).thenReturn(students);

        List<Student> expected = service.findStudentsWithMoreGradesThan(2);

        assertThat(expected)
                .hasSize(3)
                .extracting(Student::getName)
                .containsExactly("John Doe", "Jane Doe", "Jonathan Doe");
    }
}