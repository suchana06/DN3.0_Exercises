CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
BEGIN
    -- Update the salary of the employee by the given percentage
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    -- Raise an error if the employee ID does not exist
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID does not exist');
    END IF;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback the transaction in case of any error
        ROLLBACK;
        -- Log the error message
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
