import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaksi extends Nasabah {
    private LocalDateTime date;
    private String transactionType;
    private String description;
    private int amount;
    private ArrayList<String> history;
    private Nasabah nasabah;

    public Transaksi(Nasabah newNasabah, LocalDateTime newDate, String transactionType) {
        super(newNasabah.getEmail(), newNasabah.getPassword());
        this.nasabah = newNasabah;
        this.date = newDate;
        setTransactionType(transactionType);
        this.history = new ArrayList<>();
    }

    // Getter
    public LocalDateTime getDate() {
        return date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    // Setter
    public void setTransactionType(String newTransactionType) {
        switch (newTransactionType) {
            case "2":
                this.transactionType = "Deposit";
                break;
            case "3":
                this.transactionType = "Withdraw";
                break;
            case "4":
                this.transactionType = "Trasnfer";
                break;
            case "5":
                this.transactionType = "History";
                break;
            default:
                break;
        }
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void deposit(int newAmount, String description) {
        if (newAmount > 0) {
            nasabah.setBalance(nasabah.getBalance() + newAmount);
            // nasabah.balance += newAmount;
            setDescription(description);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            history.add(getTransactionType() + ": " + newAmount + " | Description: " + getDescription() + " | Date: "
                    + dtf.format(getDate()));

            System.out.println("Transaction added to history: " + history);
            System.out.println("");

            // System.out.println(nasabah.getBalance());
            // System.out.println("Date: " + LocalDateTime.now());

            // displayHistory();
        }
    }

    public void withdraw(int newAmount, String description) {
        if (newAmount > 0 && nasabah.getBalance() >= newAmount) {
            nasabah.setBalance(nasabah.getBalance() - newAmount);
            setDescription(description);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            history.add(getTransactionType() + ": " + newAmount + " | Description: " + getDescription() + " | Date: "
                    + dtf.format(getDate()));

            System.out.println("Transaction added to history: " + history);
            System.out.println("");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            System.out.println("");
        }
    }

    public void transfer(int newAmount, String description) {
        if (newAmount > 0 && nasabah.getBalance() >= newAmount) {
            nasabah.setBalance(nasabah.getBalance() - newAmount);
            setDescription(description);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            history.add(getTransactionType() + ": " + newAmount + " | Description: " + getDescription() + " | Date: "
                    + dtf.format(getDate()));

            System.out.println("Transaction added to history: " + history);
            System.out.println("");
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
            System.out.println("");
        }
    }

    public void infoAkun() {
        System.out.println("==============================");
        System.out.println("Account Info");
        System.out.println("==============================");
        System.out.println("Account Number: " + nasabah.getAccountNumber());
        System.out.println("Card Type: " + nasabah.getCardType());
        System.out.println("Name: " + nasabah.getName());
        System.out.println("Email: " + nasabah.getEmail());
        System.out.println("Account Balance: " + nasabah.getBalance());
        System.out.println("");
    }

    // Menampilkan history
    public void displayHistory() {
        System.out.println("==============================");
        System.out.println("Displaying History");
        System.out.println("==============================");
        for (String transaction : history) {
            System.out.println(transaction);
        }
        System.out.println("");
    }

}
