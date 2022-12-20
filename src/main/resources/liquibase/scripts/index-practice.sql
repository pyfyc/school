-- liquibase formatted sql

-- changeset alexeym75:1
CREATE INDEX student_name_index ON student (name);

-- changeset alexeym75:2
CREATE INDEX faculty_name_color_index ON faculty (name, color);
