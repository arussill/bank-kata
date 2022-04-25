import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Account {
    //    private String addressee;
    private Integer balance;
    private HashMap<LocalDate, Integer> mapDeposit = new HashMap<>();
    private HashMap<LocalDate, Integer> mapWithdraw = new HashMap<>();
    HashMap<LocalDate, Integer> mapStatus = new HashMap<>();

    void deposit(Integer amount, String date) {
        LocalDate day = formatterDate(date);
        balance += amount;
        mapDeposit.put(day, amount);
        mapStatus.put(day, balance);
    }

    void withdraw(Integer amount, String date) {
        LocalDate day = formatterDate(date);
        balance -= amount;
        mapWithdraw.put(day, amount);
        mapStatus.put(day, balance);
    }

    private LocalDate formatterDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    void printStatements() {
        mapStatus.forEach((k, v) -> {
            if (mapDeposit.containsKey(k)) {
                System.out.println("Fecha: " + k + "| Debito: " + mapDeposit.getOrDefault(k, 0) + "| Balance " + v);
            } else {
                System.out.println("Fecha: " + k + "| Credito: " + mapWithdraw.getOrDefault(k, 0) + "| Balance " + v);
            }
        });

    }

}
