--CREATE TABLE offer_letters (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    candidate_name VARCHAR(255) NOT NULL,
--    candidate_email VARCHAR(255) NOT NULL UNIQUE,
--    phone_number VARCHAR(20) NOT NULL,
--    job_position VARCHAR(255) NOT NULL,
--    salary_package DECIMAL(10,2) NOT NULL,
--    employment_type ENUM('Full-time', 'Part-time', 'Contract') NOT NULL,
--    work_location VARCHAR(255) NOT NULL,
--    offer_date DATE NOT NULL,
--    hr_contact_person VARCHAR(255) NOT NULL,
--    status ENUM('Pending', 'Accepted', 'Rejected') DEFAULT 'Pending'
--);




CREATE TABLE offer_letters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    candidate_name VARCHAR(255) NOT NULL,
    candidate_email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    job_position VARCHAR(255) NOT NULL,
    salary_package DECIMAL(10,2) NOT NULL,
    employment_type VARCHAR(50) NOT NULL,
    work_location VARCHAR(255) NOT NULL,
    offer_date DATE NOT NULL,
    hr_contact_person VARCHAR(255) NOT NULL,
    status VARCHAR(20) DEFAULT 'Pending'
);