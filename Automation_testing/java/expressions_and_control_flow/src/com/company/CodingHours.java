package com.company;

public class CodingHours {
  public static void main(String[] args) {

    // An average Green Fox attendee codes 6 hours daily
    // The semester is 17 weeks long
    //
    // Print how many hours is spent with coding in a semester by an attendee,
    // if the attendee only codes on workdays.
    //
    // Print the percentage of the coding hours in the semester if the average
    // work hours weekly is 52

    int codingHoursPerDay = 6;
    int sessionWeekNumber = 17;
    System.out.println(
        "Egy félév során a hallgató "
            + sessionWeekNumber * 5 * codingHoursPerDay
            + " órát tölt kódolással.");
    int averageWorkingHoursPerWeek = 52;
    int perc =
        (averageWorkingHoursPerWeek * sessionWeekNumber * 100) / (sessionWeekNumber * 7 * 24);
    System.out.println("17 hét teljes idejébõl " + perc + "%-ot tölt kódolással a hallgató.");
  }
}
