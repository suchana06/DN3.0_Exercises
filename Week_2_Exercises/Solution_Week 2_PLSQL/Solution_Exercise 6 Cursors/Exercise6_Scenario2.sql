DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance FROM Accounts;
BEGIN
    -- Loop through all accounts
    FOR r_account IN c_accounts LOOP
        -- Deduct an annual maintenance fee from the balance
        UPDATE Accounts
        SET Balance = Balance - 100 -- assuming the annual fee is $100
        WHERE AccountID = r_account.AccountID;
    END LOOP;
    COMMIT;
END;
/
