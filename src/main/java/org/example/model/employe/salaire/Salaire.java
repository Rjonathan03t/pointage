package org.example.model.employe.salaire;

public class Salaire {
    private final double salaire_brut;
    private double salaire_net;
    public Salaire(double salaire_brut) {
        this.salaire_brut = salaire_brut;
        this.salaire_net = calcul_salaire_net();
    }

    public double getSalaire_brut() {
        return salaire_brut;
    }


    @Override
    public String toString() {
        return " salaire net = "+salaire_net;
    }

    public double calcul_salaire_net(){
        double calcul = getSalaire_brut() * 0.8;
        salaire_net +=  calcul;
        return salaire_net;
    }

}
