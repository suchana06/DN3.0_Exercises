DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate FROM Loans;
BEGIN
    -- Loop through all loans
    FOR r_loan IN c_loans LOOP
        -- Update the interest rate based on the new policy (e.g., increase by 0.5%)
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = r_loan.LoanID;
    END LOOP;
    COMMIT;
END;
/
