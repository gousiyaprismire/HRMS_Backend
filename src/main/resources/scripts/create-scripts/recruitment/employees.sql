CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    job_role VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    reporting_manager VARCHAR(255),
    work_location ENUM('On-site', 'Remote', 'Hybrid') NOT NULL,
    joining_date DATE NOT NULL
);