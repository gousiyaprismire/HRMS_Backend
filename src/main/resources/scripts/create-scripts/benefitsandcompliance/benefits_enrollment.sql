CREATE TABLE benefits_enrollment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    health_insurance_plan VARCHAR(255),
    retirement_plan VARCHAR(255),
    dental_insurance_plan VARCHAR(255),
    vision_insurance_plan VARCHAR(255),
    enrollment_date DATE NOT NULL DEFAULT (CURRENT_DATE),
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);