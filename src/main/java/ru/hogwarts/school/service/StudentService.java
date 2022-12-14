package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.ListOfStudents;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new StudentNotFoundException(id);
        }
        return student;
    }

    public Student editStudent(Student student) {
        if (studentRepository.findById(student.getId()).orElse(null) == null) {
            return null;
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getStudentFaculty(long id) {
        Student student = findStudent(id);
        if (student == null) {
            return null;
        }
        return student.getFaculty();
    }

    public int getAllStudentsNumber() {
        return studentRepository.getAllStudentsNumber();
    }

    public double getAverageAge() {
        return studentRepository.getAverageAge();
    }

    public List<ListOfStudents> getLastStudentsById(int limit) {
        return studentRepository.getLastStudentsById(limit);
    }
}
