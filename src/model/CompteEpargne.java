package model;

import exceptions.MontantInvalideException;
import exceptions.SoldeInsuffisantException;

public class CompteEpargne extends Compte implements CalculInteret {
    private final double tauxInteret = 0.03;

    public CompteEpargne(String numero, double soldeInitial) {
        super(numero, soldeInitial);
    }

    public void deposer(double montant) throws MontantInvalideException {
        if (montant <= 0)
            throw new MontantInvalideException("Montant doit être positif !");
        solde += montant;
        ajouterTransaction("DEPOT", montant);
    }

    public void retirer(double montant) throws MontantInvalideException, SoldeInsuffisantException {
        if (montant <= 0)
            throw new MontantInvalideException("Montant doit être positif !");
        if (solde < montant)
            throw new SoldeInsuffisantException("Solde insuffisant pour retrait !");
        solde -= montant;
        ajouterTransaction("RETRAIT", montant);
    }

    public void appliquerInterets() {
        double interets = solde * tauxInteret;
        solde += interets;
        ajouterTransaction("INTERETS", interets);
    }
}

