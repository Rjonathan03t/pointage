package org.example.model.employe.categorie;

public sealed abstract class  Categorie permits
        CadreSuperieur,
        Chauffeur,
        Gardien,
        Normal {
    private final String nom;
    private int heure_normale_travail;
    private int salaire_par_semaine;
    private int indemnite;

    public Categorie(String nom, int heure_normale_travail, int salaire_par_semaine, int indemnite) {
        this.nom = nom;
        this.heure_normale_travail = heure_normale_travail;
        this.salaire_par_semaine = salaire_par_semaine;
        this.indemnite = indemnite;
    }
}
