--CREATE TABLE interviews (
--    id INT PRIMARY KEY AUTO_INCREMENT,
--    candidate_name VARCHAR(255) NOT NULL,
--    job_position VARCHAR(255) NOT NULL,
--    interview_date DATETIME NOT NULL,
--    interviewer VARCHAR(255) NOT NULL,
--    mode ENUM('Online', 'Offline') NOT NULL,
--    status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled'
--);
CREATE TABLE interviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    candidate_name VARCHAR(255) NOT NULL,
    job_position VARCHAR(255) NOT NULL,
    interview_date DATETIME NOT NULL,
    interviewer VARCHAR(255) NOT NULL,
    mode VARCHAR(50) NOT NULL CHECK (mode IN ('Online', 'In-Person')),
    status VARCHAR(50) NOT NULL DEFAULT 'Scheduled' CHECK (status IN ('Scheduled', 'Completed', 'Cancelled'))
);
