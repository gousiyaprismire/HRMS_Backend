CREATE TABLE appraisal_forms (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(255) NOT NULL,
    manager_name VARCHAR(255) NOT NULL,
    status ENUM('Pending', 'Approved', 'Rejected') NOT NULL,
    last_action DATE NOT NULL
);
