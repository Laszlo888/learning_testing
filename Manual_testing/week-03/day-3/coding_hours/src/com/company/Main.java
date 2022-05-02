package com.company;

public class Main {

    public static void main(String[] args) {
        int codingHoursPerDay = 6;
        int sessionWeekNumber = 17;
        System.out.println("Egy félév során a hallgató " + sessionWeekNumber * 5 * codingHoursPerDay + " órát tölt kódolással.");
        int averageWorkingHoursPerWeek = 52;
        int perc = (averageWorkingHoursPerWeek * sessionWeekNumber * 100) / (sessionWeekNumber * 7 * 24);
        System.out.println("17 hét teljes idejéből " + perc + "%-ot tölt kódolással a hallgató.");
    }
}
