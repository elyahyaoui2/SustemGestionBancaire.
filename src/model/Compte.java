package model;
import exceptions.MontantInvalideException;
import exceptions.SoldeInsuffisantException;
import exceptions.LimiteDepasseeException;
import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
    public String numero;
    protected double solde;
    protected List<Transaction> historique;

    public Compte(String numero, double soldeInitial) {
        this.numero = numero;
        this.solde = soldeInitial;
        this.historique = new ArrayList<>();
    }

    public abstract void deposer(double montant) throws MontantInvalideException;
    public abstract void retirer(double montant) throws MontantInvalideException, SoldeInsuffisantException, LimiteDepasseeException;

    public void ajouterTransaction(String type, double montant) {
        historique.add(new Transaction(type, montant));
    }

    public void afficherHistorique() {
        System.out.println("Historique du compte N°" + numero +" " );
        for (Transaction t : historique) {
            System.out.println(t);
        }
    }

    public double getSolde() {
        return solde;
    }
}




