package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Collection<Student> findByAge(int age);

    public Collection<Student> findByAgeBetween(int min, int max);

    public Collection<Student> findByFacultyId(long facultyId);

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    public int getAllStudentsNumber();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    public double getAverageAge();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT :limit", nativeQuery = true)
    public List<ListOfStudents> getLastStudentsById(@Param("limit") int limit);

}
