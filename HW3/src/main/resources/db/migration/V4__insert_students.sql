INSERT INTO students
    (id, username, full_name, gpa)
VALUES (nextval('students_id_seq'), 'alex', 'Alexey Bekmansurov', 4.0);

INSERT INTO students
(id, username, full_name, gpa, group_id)
VALUES (nextval('students_id_seq'), 'nurik', 'Nurbek Semenov', 3.8, 1);

INSERT INTO students
(id, username, full_name, gpa, group_id)
VALUES (nextval('students_id_seq'), 'aliya', 'Aliya Alexeyeva', 3.9, 2);

INSERT INTO students
(id, username, full_name, gpa)
VALUES (nextval('students_id_seq'), 'oleg', 'Oleg Serikov', 3.6);
