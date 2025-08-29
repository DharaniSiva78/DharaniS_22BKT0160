CREATE TABLE department (
    department_id BIGINT PRIMARY KEY,
    department_name VARCHAR(255)
);

CREATE TABLE employee (
    emp_id BIGINT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    department BIGINT,
    dob DATE,
    CONSTRAINT fk_department FOREIGN KEY (department) REFERENCES department(department_id)
);
