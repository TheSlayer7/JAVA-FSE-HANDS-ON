/* =========================================
EXERCISE 1: CONTROL STRUCTURES
=========================================
*/

/* Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates. 
*/
DECLARE
    v_age NUMBER;
BEGIN
    FOR r IN (SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate 
              FROM Customers c
              JOIN Loans l ON c.CustomerID = l.CustomerID) 
    LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, r.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

/* Scenario 2: A customer can be promoted to VIP status based on their balance.
Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000. 
*/
BEGIN
    FOR r_cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y' 
            WHERE CustomerID = r_cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

/* Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer. 
*/
BEGIN
    FOR r_loan IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND (SYSDATE + 30)
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || r_loan.Name || 
                             ', your loan (ID: ' || r_loan.LoanID || 
                             ') is due on ' || TO_CHAR(r_loan.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/