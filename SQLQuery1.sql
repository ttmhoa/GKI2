Create Database GiuakiJava
use GiuakiJava
CREATE TABLE employees (
    id INT PRIMARY KEY,
    full_name VARCHAR(100),
    birth_day DATE,
    phone VARCHAR(20),
    email VARCHAR(100),
    employee_type VARCHAR(50),
    employee_count INT
);
ALTER TABLE employees
DROP COLUMN employee_count;
select*from employees