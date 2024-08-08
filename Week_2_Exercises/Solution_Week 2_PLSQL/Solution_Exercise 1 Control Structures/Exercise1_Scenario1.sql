DECLARE
    v_age NUMBER;
    CURSOR c_customers IS
        SELECT CustomerID, DOB FROM Customers;
BEGIN
    -- Loop through all customers
    FOR r_customer IN c_customers LOOP
        -- Calculate the age of the customer
        v_age := TRUNC((SYSDATE - r_customer.DOB) / 365.25);
        -- Check if the customer is above 60 years old
        IF v_age > 60 THEN
            -- Apply a 1% discount to the loan interest rate for the customer
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = r_customer.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
