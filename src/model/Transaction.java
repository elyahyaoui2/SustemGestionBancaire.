package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private  LocalDateTime date;
    private  String type;
    private  double montant;

    public Transaction(String type, double montant) {
        this.date = LocalDateTime.now();
        this.type = type;
        this.montant = montant;
    }

    private String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String toString() {
        return getFormattedDate() + " - " + type + " : " + montant + " DH";
    }

}


