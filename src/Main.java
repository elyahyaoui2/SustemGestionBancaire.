import model.*;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        try {

            Client basma = new Client("elyahyaoui", "basma", "AB12345");
            Client yasmine = new Client("zoubi", "yasmine", "CD67890");

            CompteCourant courant = new CompteCourant("1001", 1000);
            CompteEpargne epargne = new CompteEpargne("2001", 2000);
            CompteEntreprise entreprise = new CompteEntreprise("3001", 10000);

            basma.addCompte(courant);
            basma.addCompte(epargne);
            yasmine.addCompte(entreprise);

            System.out.println(basma);
            System.out.println(yasmine);
            System.out.printf("Compte Courant : ", courant.getSolde());
            System.out.printf("Compte Épargne : ", epargne.getSolde());
            System.out.printf("Compte Entreprise : ", entreprise.getSolde());

            courant.deposer(500);
            courant.retirer(300);
            System.out.printf("Compte Courant après dépôt et retrait : ", courant.getSolde());

            try { courant.retirer(2000); }
            catch (SoldeInsuffisantException e) {
                System.out.println("Erreur retrait 2000 DH : " + e.getMessage());
            }

            if (epargne.getSolde() >= 500) {
                epargne.retirer(500);
                courant.deposer(500);
                epargne.ajouterTransaction("VIREMENT ENVOYE", 500);
                courant.ajouterTransaction("VIREMENT RECU", 500);
                System.out.println("Virement de 500 DH effectué");
            }

            epargne.appliquerInterets();
            System.out.printf("Solde Épargne après intérêts : ", epargne.getSolde());

            courant.afficherHistorique();
            System.out.println();
            epargne.afficherHistorique();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}


