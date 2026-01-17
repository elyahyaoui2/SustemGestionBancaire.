package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String cin;
    private List<Compte> comptes;

    public Client(String nom, String prenom, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.comptes = new ArrayList<>();
    }

    public void addCompte(Compte compte) {
        comptes.add(compte);
    }

    public void afficherComptes() {
        System.out.println("Comptes de " + nom + " " + prenom + " :");
        for (Compte c : comptes) {
            System.out.println(" - N°" + c.numero + " : " + c.getSolde() + " DH");
        }
    }

    public List<Compte> getComptes() {
        return comptes;
    }
    public String toString() {
        return "Client : " + nom + " " + prenom + " (CIN : " + cin + ")";
    }
}

