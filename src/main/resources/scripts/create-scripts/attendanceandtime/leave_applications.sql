CREATE TABLE leave_applications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    leave_type ENUM('Sick Leave', 'Vacation', 'Casual Leave', 'Maternity Leave', 'Paternity Leave', 'Other') NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    FOREIGN KEY (emp_id) REFERENCES employees(emp_id) ON DELETE CASCADE
);
