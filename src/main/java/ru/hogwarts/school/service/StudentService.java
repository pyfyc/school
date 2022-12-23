package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        logger.debug("Calling constructor StudentService");
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.debug("Calling method createStudent");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.debug("Calling method findStudent (studentId = {})", id);
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new StudentNotFoundException(id);
        }
        return student;
    }

    public Student editStudent(Student student) {
        logger.debug("Calling method editStudent (studentId = {})", student.getId());
        if (studentRepository.findById(student.getId()).orElse(null) == null) {
            return null;
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.debug("Calling method deleteStudent (studentId = {})", id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudentsByAge(int age) {
        logger.debug("Calling method getStudentsByAge (age = {})", age);
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.debug("Calling method findByAgeBetween (minAge = {}, maxAge = {})", min, max);
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getStudentFaculty(long id) {
        logger.debug("Calling method getStudentFaculty (studentId = {})", id);
        Student student = findStudent(id);
        if (student == null) {
            return null;
        }
        return student.getFaculty();
    }

    public int getAllStudentsNumber() {
        logger.debug("Calling method getAllStudentsNumber");
        return studentRepository.getAllStudentsNumber();
    }

    public double getAverageAge() {
        logger.debug("Calling method getAverageAge");
        return studentRepository.getAverageAge();
    }

    public List<ListOfStudents> getLastStudentsById(int limit) {
        logger.debug("Calling method getLastStudentsById (limit = {})", limit);
        return studentRepository.getLastStudentsById(limit);
    }
}
