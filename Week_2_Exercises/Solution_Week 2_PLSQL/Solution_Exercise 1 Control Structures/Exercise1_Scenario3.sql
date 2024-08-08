DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    -- Loop through all loans due in the next 30 days
    FOR r_loan IN c_loans LOOP
        -- Print a reminder message for each customer
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || r_loan.LoanID || ' for customer ' || r_loan.Name || ' is due on ' || TO_CHAR(r_loan.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
