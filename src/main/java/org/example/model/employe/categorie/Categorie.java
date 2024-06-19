package org.example.model.employe.categorie;

public sealed abstract class  Categorie permits
        CadreSuperieur,
        Chauffeur,
        Gardien,
        Normal {
    private final String nom;
    private int heure_normale_travail;
    private double salaire_par_semaine;

    public Categorie(String nom, int heure_normale_travail, double salaire_par_semaine) {
        this.nom = nom;
        this.heure_normale_travail = heure_normale_travail;
        this.salaire_par_semaine = salaire_par_semaine;
    }
}
