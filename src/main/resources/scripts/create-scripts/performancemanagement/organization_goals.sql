CREATE TABLE organization_goals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    period VARCHAR(255) NOT NULL,
    goal_description TEXT NOT NULL,
    target VARCHAR(255) NOT NULL,
    rollup_method VARCHAR(255)
);
