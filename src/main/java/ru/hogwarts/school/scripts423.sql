-- получить информацию обо всех студентах
-- (достаточно получить только имя и возраст студента)
-- школы Хогвартс вместе с названиями факультетов.
SELECT s.name, s.age, f.name
FROM student s
         LEFT JOIN faculty f on s.faculty_id = f.id;

-- получить только тех студентов, у которых есть аватарки.
SELECT s.name, s.age
FROM avatar a
         INNER JOIN student s on s.id = a.student_id
