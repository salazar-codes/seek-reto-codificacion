CREATE TABLE IF NOT EXISTS candidates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    salary_expected DECIMAL(10, 2) NOT NULL,
    phone_number VARCHAR(50),
    date_of_birth DATE
);