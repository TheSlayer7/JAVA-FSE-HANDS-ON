import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BankAccountTest {

    @Test
    public void depositAddsToBalance() {
        BankAccount account = new BankAccount(100.0);

        account.deposit(50.0);

        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    public void withdrawSubtractsFromBalance() {
        BankAccount account = new BankAccount(100.0);

        account.withdraw(30.0);

        assertEquals(70.0, account.getBalance(), 0.0001);
    }

    @Test
    public void initialBalanceIsRetained() {
        BankAccount account = new BankAccount(250.0);

        assertEquals(250.0, account.getBalance(), 0.0001);
    }
}