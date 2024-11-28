CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

INSERT INTO users (email, password, first_name, last_name)
VALUES
    ('juan.perez@example.com', 'hashed_password_123', 'Juan', 'Pérez'),
    ('maria.gomez@example.com', 'hashed_password_456', 'María', 'Gómez'),
    ('carlos.lopez@example.com', 'hashed_password_789', 'Carlos', 'López');
