CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    dob DATE NOT NULL,
    joining_date DATE NOT NULL,
    mobile VARCHAR(15) UNIQUE NOT NULL,
    aadhar VARCHAR(20) UNIQUE NOT NULL,
    account_no VARCHAR(20) UNIQUE NOT NULL,
    department VARCHAR(100) NOT NULL,
    designation VARCHAR(100) NOT NULL,
    previous_company VARCHAR(150),
    pf_number VARCHAR(50) UNIQUE,
    salary DECIMAL(10,2) NOT NULL,
    current_address TEXT NOT NULL,
    permanent_address TEXT NOT NULL,
    status ENUM('Active', 'Inactive') NOT NULL DEFAULT 'Active'
);
