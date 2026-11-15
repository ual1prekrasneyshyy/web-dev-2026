INSERT INTO courses
(
    id,
    code,
    name,
    description,
    credits
)
VALUES
(
    nextval('courses_id_seq'),
    'MobDev',
    'Mobile Programming',
    'Developing Android based mobile applications using Kotlin programming language',
    3
);

INSERT INTO courses
(
    id,
    code,
    name,
    description,
    credits
)
VALUES
(
    nextval('courses_id_seq'),
    'WebDev',
    'Web Development',
    'Developing backend and frontend components of web application with containerization',
    3
);

INSERT INTO courses
(
    id,
    code,
    name,
    description,
    credits
)
VALUES
(
    nextval('courses_id_seq'),
    'GPP',
    'Game Programming Patterns',
    'Learning and applying patterns used in game programming industry',
    3
);

INSERT INTO courses
(
    id,
    code,
    name,
    description,
    credits
)
VALUES
(
    nextval('courses_id_seq'),
    'AI',
    'Artificial Intelligence',
    'Learning the theoretical background of AI',
    3
);

INSERT INTO courses
(
    id,
    code,
    name,
    description,
    credits
)
VALUES
(
    nextval('courses_id_seq'),
    'SSD',
    'Smart Systems Design',
    'Learning the theoretical background of designing smart systems',
    3
);