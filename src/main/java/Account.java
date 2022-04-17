import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Account {
    private String addressee;
    private int balance;
    HashMap<LocalDate, Integer> mapDeposit = new HashMap<>();
    HashMap<LocalDate, Integer> mapWithdraw = new HashMap<>();
    HashMap<LocalDate, Integer> mapTransfer = new HashMap<>();
    HashMap<String, Object> mapStatus = new HashMap<>();

    void deposit(int amount, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate day = LocalDate.parse(date, formatter);
        mapDeposit.put(day, amount);
        mapStatus.put("deposit", mapDeposit);
    }

    void withdraw(int amount, String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate day = LocalDate.parse(date, formatter);
        mapWithdraw.put(day, amount);
        mapStatus.put("withdraw", mapWithdraw);
    }

    void transfer(int amount, String date, String number){
        addressee = number;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate day = LocalDate.parse(date, formatter);
        mapTransfer.put(day, amount);
        mapStatus.put("transfer", mapTransfer);
    }

    void printStatements() {
        System.out.println(mapStatus);
    }

}
