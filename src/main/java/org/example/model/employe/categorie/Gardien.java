package org.example.model.employe.categorie;

public final class Gardien extends Categorie {
    public Gardien(String nom, int heure_normale_travail, double salaire_par_semaine) {
        super(nom, heure_normale_travail, salaire_par_semaine);
    }
    public Gardien(String nom){
        this(nom,56,10000);
    }
}
