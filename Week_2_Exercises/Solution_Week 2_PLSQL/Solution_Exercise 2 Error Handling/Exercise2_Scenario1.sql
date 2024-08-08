CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check the balance of the from account
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account_id;

    -- Raise an error if the balance is insufficient
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
    END IF;

    -- Perform the transfer
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account_id;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback the transaction in case of any error
        ROLLBACK;
        -- Log the error message
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
