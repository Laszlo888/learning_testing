package com.company;

public class Main {

    public static void main(String[] args) {
        double massInKg = 81.2;
        double heightInM = 1.78;

        // Számíttasd és írasd ki a testtömeg-indexet (BMI)
        // bmi=weight[kg]/height[m]*height[m]
        // a változókat használva

        System.out.println("BMI: " + massInKg / (heightInM * heightInM));

    }
}
