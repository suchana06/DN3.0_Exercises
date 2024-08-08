CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
BEGIN
    -- Insert a new customer into the Customers table
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        -- Log an error message if the customer ID already exists
        RAISE_APPLICATION_ERROR(-20003, 'Customer ID already exists');
    WHEN OTHERS THEN
        -- Rollback the transaction in case of any other error
        ROLLBACK;
        -- Log the error message
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
