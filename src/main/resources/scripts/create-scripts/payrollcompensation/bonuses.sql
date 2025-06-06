CREATE TABLE bonuses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    bonus_amount DECIMAL(10,2) NOT NULL,
    bonus_type VARCHAR(100) NOT NULL,
    month VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employees(emp_id) ON DELETE CASCADE
);
