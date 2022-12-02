package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    public Collection<Faculty> findByColor(String color);

    public Faculty findFirstByNameIgnoreCase(String name);

    public Faculty findFirstByColorIgnoreCase(String color);
}
