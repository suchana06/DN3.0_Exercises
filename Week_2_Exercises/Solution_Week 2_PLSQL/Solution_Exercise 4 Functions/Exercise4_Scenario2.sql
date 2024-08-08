CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_interest_rate NUMBER,
    p_duration_years NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_monthly_installment NUMBER;
    v_number_of_payments NUMBER;
BEGIN
    -- Calculate the monthly interest rate
    v_monthly_rate := p_interest_rate / 12 / 100;
    -- Calculate the number of monthly payments
    v_number_of_payments := p_duration_years * 12;
    -- Calculate the monthly installment using the formula
    v_monthly_installment := p_loan_amount * v_monthly_rate / (1 - POWER(1 + v_monthly_rate, -v_number_of_payments));
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/
