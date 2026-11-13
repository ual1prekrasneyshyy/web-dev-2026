CREATE TABLE groups
(
    id BIGSERIAL,
    name VARCHAR(10) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE courses
(
    id BIGSERIAL,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    credits INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE students
(
    id BIGSERIAL,
    username VARCHAR(50) NOT NULL UNIQUE,
    full_name VARCHAR(80) NOT NULL,
    gpa REAL NOT NULL,
    group_id BIGINT,
    PRIMARY KEY(id),
    FOREIGN KEY(group_id) REFERENCES groups(id)
);

CREATE TABLE groups_courses
(
    group_id BIGINT,
    course_id BIGINT,
    FOREIGN KEY(group_id) REFERENCES groups(id),
    FOREIGN KEY(course_id) REFERENCES courses(id)
);

