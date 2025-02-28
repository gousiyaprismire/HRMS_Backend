CREATE TABLE timesheet_records (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    work_hours INT NOT NULL,
    overtime INT DEFAULT 0,
    shift ENUM('Morning', 'Evening', 'Night') NOT NULL,
    comments TEXT
);
