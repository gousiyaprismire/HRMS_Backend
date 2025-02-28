CREATE TABLE payslips (
    id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    pan VARCHAR(20) NOT NULL,
    uan VARCHAR(20) NOT NULL,
    bank_days INT NOT NULL,
    lop_days INT NOT NULL,
    doj DATE NOT NULL,  -- Date of Joining
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    total_earnings DECIMAL(10,2) NOT NULL,
    month VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employees(emp_id) ON DELETE CASCADE
);
