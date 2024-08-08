CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    -- Get the current balance of the account
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    -- Check if the balance is sufficient
    RETURN v_balance >= p_amount;
END HasSufficientBalance;
/
