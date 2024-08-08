DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    -- Loop through all customers
    FOR r_customer IN c_customers LOOP
        -- Check if the customer's balance is over $10,000
        IF r_customer.Balance > 10000 THEN
            -- Set the IsVIP flag to TRUE
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = r_customer.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
