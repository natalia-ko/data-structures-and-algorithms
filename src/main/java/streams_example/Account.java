package streams_example;

public class Account {
    private long id;
    private Currency currency;
    private int balance;
    private String accNumber;

    public Account() {
    }

    public Account(long id, Currency currency, int balance, String accNumber) {
        this.id = id;
        this.currency = currency;
        this.balance = balance;
        this.accNumber = accNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    private static long currentId = 0;

    public static long generateId() {
        return currentId++;
    }

    public static enum Currency {
        RUR, USD, EU
    }
}
