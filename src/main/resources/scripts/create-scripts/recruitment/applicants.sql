CREATE TABLE applicants (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    mobile VARCHAR(20) NOT NULL,
    degree VARCHAR(100),
    department VARCHAR(100),
    applied_job VARCHAR(100),
    expected_salary DECIMAL(10,2),
    appreciation INT DEFAULT 0
);
