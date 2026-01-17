package model;

import exceptions.MontantInvalideException;
import exceptions.SoldeInsuffisantException;

public class CompteCourant extends Compte {
    private  double decouvertMax = 500.0;

    public CompteCourant(String numero, double soldeInitial) {
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
        if (solde + decouvertMax < montant)
            throw new SoldeInsuffisantException("Solde insuffisant pour retrait !");
        solde -= montant;
        ajouterTransaction("RETRAIT", montant);
    }
}

