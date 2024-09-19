CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(45) NOT NULL,
        RA VARCHAR(11) NOT NULL UNIQUE,
        CPF VARCHAR(11) NOT NULL UNIQUE,
        email VARCHAR(255) NOT NULL UNIQUE,
        curso_id BIGINT,
        date_birth DATE,
        registration DATE,
        FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE SET NULL
);