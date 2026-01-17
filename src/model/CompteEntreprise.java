package model;

import exceptions.MontantInvalideException;
import exceptions.SoldeInsuffisantException;

public class CompteEntreprise extends Compte {

    public CompteEntreprise(String numero, double soldeInitial) {
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
            throw new SoldeInsuffisantException("Solde insuffisant !");
        solde -= montant;
        ajouterTransaction("RETRAIT", montant);
    }
}


