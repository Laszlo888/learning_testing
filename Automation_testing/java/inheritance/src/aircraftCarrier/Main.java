package aircraftCarrier;

public class Main {
  public static void main(String[] args) throws Exception {

    // Aircrafts
    // Create a class that represents an aircraft
    // There are 2 types of aircrafts: F16 and F35
    // Both aircrafts should keep track of their ammunition
    //
    // F16
    // Max ammo: 8
    // Base damage: 30
    //
    // F35
    // Max ammo: 12
    // Base damage: 50
    //
    // All aircrafts should be created with an empty ammo storage
    // Methods:
    // fight()
    // It should use all the ammo (set it to 0) and it should return the damage it causes
    // damage is calculated by multiplying the base damage by the ammunition
    //
    // refillAmmo()
    // It should take a number as parameter that represents the ammunition coming from a station
    // Increase the ammo of the aircraft by the right amount
    // It can't have more ammo than the parameter value or the max ammo of the aircraft
    // It should return the remaining (unused) ammo
    // Eg. Filling an empty F35 with 300 would completely fill the storage of the aircraft and
    // would return the remaining 288

    // getType()
    // It should return the type of the aircraft as a string
    //
    // getStatus()
    // It should return a string like: Type F35, Ammo: 10, Base Damage: 50, All Damage: 500
    //
    // isPriority()
    // It should return if the aircraft is priority in the ammo fill queue. It's true for F35 and false for F16
    //
    // Carrier
    // Create a class that represents an aircraft-carrier
    // The carrier should be able to store aircrafts
    // Each carrier should have a store of ammo represented by a number
    // The initial ammo should be given as a constructor parameter
    // The carrier also has a health point which is also given as a constructor parameter
    //
    // Methods:
    // add()
    // It should take a new aircraft and add it to its storage
    //
    // fill()
    // It should fill all the aircrafts with ammo and subtract the taken ammo from the ammo storage
    // If there is not enough ammo it should start to fill the aircrafts that are priority first
    // It should throw an exception if there is no ammo when this method is called

    // fight()
    // It should take another carrier as a reference parameter and
    // fire all the ammo from the aircrafts to it
    // subtract all the damage from the other carrier's health points
    //
    // getStatus()
    // It should return a string describing its, and all of its aircrafts' statuses in the
    // following format:

    //    HP: 5000, Aircraft count: 5, Ammo Storage: 2300, Total damage: 2280
    //    Aircrafts:
    //    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
    //    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
    //    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
    //    Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
    //    Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
    //
    // If the health points are 0 then it should return: It's dead Jim :(

    AircraftCarrier carrier = new AircraftCarrier(580, 215);
    AircraftCarrier carrier2 = new AircraftCarrier(16, 317);
    F35 f351 = new F35();
    F35 f352 = new F35();
    F16 f161 = new F16();
    F16 f162 = new F16();

    carrier.add(f351);
    Aircraft.refillAmmo(7, f351);
    carrier.add(f352);
    Aircraft.refillAmmo(9, f352);
    carrier.add(f161);
    Aircraft.refillAmmo(3, f161);
    carrier.add(f162);

    System.out.println();
    System.out.println("refill:  ammo left: " + Aircraft.refillAmmo(25, f162));
    System.out.println();
    System.out.println("fight: f162 caused " + Aircraft.fight(f162) + " damage");
    System.out.println();
    System.out.println("Type: " + f161.getType());
    System.out.println();
    System.out.println("Status: " + f352.getStatus());
    System.out.println();
    System.out.println("Priority: " + f351.isPriority());
    System.out.println();
    System.out.println("Carrier status: \n" + AircraftCarrier.getStatus(carrier));

    F35 f353 = new F35();
    F35 f354 = new F35();
    F16 f163 = new F16();
    F16 f164 = new F16();

    carrier2.add(f353);
    carrier2.add(f354);
    carrier2.add(f163);
    carrier2.add(f164);

    // fill according to priority
    carrier2.fill();
    System.out.println();
    System.out.println("Fill according to priority because of low ammo");
    System.out.println();
    System.out.println("Carrier status: \n" + AircraftCarrier.getStatus(carrier2));
    carrier2.setCarrierAmmo(100);

    // fill everybody to max.
    carrier2.fill();
    System.out.println();
    System.out.println("Filling everybody:");
    System.out.println();
    System.out.println("Carrier status: \n" + AircraftCarrier.getStatus(carrier2));

    // carrier fight
    AircraftCarrier.fight(carrier, carrier2);
    System.out.println();
    System.out.println("Carrier fight:");
    System.out.println();
    System.out.println("Carrier status: \n" + AircraftCarrier.getStatus(carrier2));
    System.out.println();
    System.out.println("Carrier status: \n" + AircraftCarrier.getStatus(carrier));
    System.out.println();
  }
}
