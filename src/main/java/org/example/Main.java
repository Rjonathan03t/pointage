package org.example;

import org.example.model.employe.salaire.Salaire;

public class Main {
    public static void main(String[] args) {
        Salaire debutant = new Salaire(1000,0);
        System.out.println(debutant.calcul_salaire_net());

        }
    }
