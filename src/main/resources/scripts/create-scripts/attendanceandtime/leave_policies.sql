CREATE TABLE leave_policies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(50) NOT NULL,
    days INT NOT NULL,
    description TEXT
);