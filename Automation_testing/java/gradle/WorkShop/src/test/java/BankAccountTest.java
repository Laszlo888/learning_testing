import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    BankAccount bAc = new BankAccount();

    @Test
    void depMustBeAddedToBalance() {
        int dep = 150;
        Integer result =1150;
        bAc.deposit(dep);
        Assertions.assertEquals(result, bAc.balance);
    }

    @Test
    void withMustBeWithdrawedFromBalance() {
        int with = 150;
        Integer result = 850;
        bAc.withdraw(with);
        Assertions.assertEquals(result, bAc.balance);
    }

}
