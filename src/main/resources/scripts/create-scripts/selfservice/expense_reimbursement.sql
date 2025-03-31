CREATE TABLE expense_reimbursement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    expense_title VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    receipt_path VARCHAR(255),
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending'
);
