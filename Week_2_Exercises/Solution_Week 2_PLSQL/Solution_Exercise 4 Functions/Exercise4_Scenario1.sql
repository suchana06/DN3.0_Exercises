CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    -- Calculate the age based on the date of birth
    v_age := TRUNC((SYSDATE - p_dob) / 365.25);
    RETURN v_age;
END CalculateAge;
/
