CREATE TABLE joblisting (
    title VARCHAR(255) PRIMARY KEY, -- Job title, which will be unique
    applications INT DEFAULT 0 -- Number of applications for the job
);
