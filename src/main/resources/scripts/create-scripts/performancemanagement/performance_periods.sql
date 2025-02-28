CREATE TABLE performance_periods (
    id INT PRIMARY KEY AUTO_INCREMENT,
    period_name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);
