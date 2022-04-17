import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Account {
    HashMap<LocalDate, Integer> mapDeposit = new HashMap<>();
    HashMap<LocalDate, Integer> mapWithdraw = new HashMap<>();

    void deposit(int amount, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate day = LocalDate.parse(date, formatter);
        mapDeposit.put(day, amount);
    }

    void withdraw(int amount, String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate day = LocalDate.parse(date, formatter);
        mapWithdraw.put(day, amount);
    }

    void printStatements() {
        System.out.println(mapDeposit);
        System.out.println(mapWithdraw);
    }

}
