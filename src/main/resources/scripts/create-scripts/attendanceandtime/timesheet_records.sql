CREATE TABLE timesheet (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    work_hours INT NOT NULL,
    overtime INT DEFAULT 0,
    shift VARCHAR(20) NOT NULL,
    comments TEXT
);
