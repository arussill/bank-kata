import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;

public class Account {
//    private String addressee;
    private int balance;
    HashMap<LocalDate, Integer> mapDeposit = new HashMap<>();
    HashMap<LocalDate, Integer> mapWithdraw = new HashMap<>();
//    HashMap<LocalDate, Integer> mapTransfer = new HashMap<>();
    HashMap<LocalDate, Integer> mapStatus = new HashMap<>();

    void deposit(int amount, String date) {
        LocalDate day = formatterDate(date);
        balance += amount;
        mapDeposit.put(day, amount);
        mapStatus.put(day, balance);
    }

    void withdraw(int amount, String date){
        LocalDate day = formatterDate(date);
        balance -= amount;
        mapWithdraw.put(day, amount);
        mapStatus.put(day, balance);
    }

//    void transfer(int amount, String date, String number){
//        addressee = number;
//        LocalDate day = formateaDate(date);
//        mapTransfer.put(day, amount);
//        mapStatus.put("transfer", mapTransfer);
//    }

    private LocalDate formatterDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    void printStatements() {
        mapStatus.forEach((k,v) -> {
            if(mapDeposit.containsKey(k)){
                System.out.println("Fecha: " + k + "| Debito: " + mapDeposit.getOrDefault(k,0) + "| Balance " + v );
            }else{
                System.out.println("Fecha: " + k + "| Credito: " + mapWithdraw.getOrDefault(k,0) + "| Balance " + v );
            }
        });

    }

}
