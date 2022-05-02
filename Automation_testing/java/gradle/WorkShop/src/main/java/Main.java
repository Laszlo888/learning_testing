public class Main {
    public static void main(String[] args) {
        BankAccount bAc = new BankAccount();

        bAc.deposit(142);
        System.out.println(bAc.balance);
    }
}
