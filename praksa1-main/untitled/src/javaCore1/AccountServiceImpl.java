package javaCore1;

interface AccountService {
    /**
     * It finds an account by owner id
     *
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);

    /**
     * It count the number of account with balance > the given value
     *
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

class AccountServiceImpl implements AccountService {
    private Account[] accounts;

    //Konstruktor za samu klasu
    private AccountServiceImpl(Account[] acc) {
        this.accounts = acc;
    }

    //Metode iz interfejsa
    @Override
    public Account findAccountByOwnerId(long id) {
        for (Account acc : accounts) {
            if (acc.getOwner().getId() == id)
                return acc;
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        long n = 0;
        for (Account acc : accounts)
            if (acc.getBalance() > value)
                n++;
        return n;
    }

    //Main metoda je u samoj klasi javaCore1.AccountServiceImpl
    public static void main(String[] args) {

        //Ispod se nalaze kreiranje datih klasa javaCore1.User i javaCore1.Account
        User firstUser = new User(1, "Marko", "Markovic");
        User secondUser = new User(2, "Stefan", "Stefanovic");

        Account accOne = new Account(11, 5000, firstUser);
        Account accTwo = new Account(21, 10000, firstUser);
        Account accThree = new Account(31, 15000, secondUser);

        Account[] accounts = {accOne, accTwo, accThree};

        AccountServiceImpl service = new AccountServiceImpl(accounts);

        Account pronadjiAcc = service.findAccountByOwnerId(2L);
        if (pronadjiAcc != null) {
            System.out.println("Pronadjen nalog za " + pronadjiAcc.getOwner().getFirstName() + " " + pronadjiAcc.getOwner().getLastName());
        } else {
            System.out.println("Nije pronadjen nalog za korisnika.");
        }

        long value = 9000;
        long brojKorisnikaSaVecimParama = service.countAccountsWithBalanceGreaterThan(value);
        System.out.println("Broj naloga sa vise od " + value + " na racunu je " + brojKorisnikaSaVecimParama);
    }
}

class Account {

    private final long id;
    private final long balance;
    private final User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}

class User {

    private final long id;
    private final String firstName;
    private final String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}