DECLARE
    CURSOR c_transactions IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, c.CustomerID, c.Name
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);
BEGIN
    -- Loop through all transactions for the current month
    FOR r_transaction IN c_transactions LOOP
        -- Print a statement for each customer
        DBMS_OUTPUT.PUT_LINE('Statement for Customer ' || r_transaction.Name || ':');
        DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || r_transaction.TransactionID || ', Date: ' || TO_CHAR(r_transaction.TransactionDate, 'YYYY-MM-DD') || ', Amount: ' || r_transaction.Amount || ', Type: ' || r_transaction.TransactionType);
    END LOOP;
END;
/
