package aircraftCarrier;

import java.util.ArrayList;
import java.util.List;

public class AircraftCarrier {
  double carrierAmmo;
  double healthPoint;
  List<Aircraft> airCrafts;

  public AircraftCarrier(double carrierAmmo, double healthPoint) {
    this.carrierAmmo = carrierAmmo;
    this.healthPoint = healthPoint;
    airCrafts = new ArrayList<>();
  }

  public double getCarrierAmmo() {
    return carrierAmmo;
  }

  public double getHealthPoint() {
    return healthPoint;
  }

  public List<Aircraft> getAirCrafts() {
    return airCrafts;
  }

  public void setCarrierAmmo(double carrierAmmo) {
    this.carrierAmmo = carrierAmmo;
  }

  public void setHealthPoint(double healthPoint) {
    this.healthPoint = healthPoint;
  }

  void add(Aircraft aircraft) {
    airCrafts.add(aircraft);
  }

  void fill() throws Exception {
    if (carrierAmmo > 0) {

      // check how many ammo needed to fill everybody
      double ammoNeededToFillPlanes = 0;
      for (int i = 0; i < airCrafts.size(); i++) {
        double temp = airCrafts.get(i).getMaxAmmo() - airCrafts.get(i).getAmmo();
        if (temp > 0) {
          ammoNeededToFillPlanes += temp;
        }
      }

      // if we have enough ammo to fill everybody
      if (carrierAmmo >= ammoNeededToFillPlanes) {
        for (int i = 0; i < airCrafts.size(); i++) {
          airCrafts.get(i).setAmmo(airCrafts.get(i).getMaxAmmo());
        }
        carrierAmmo -= ammoNeededToFillPlanes;
      }

      // if we haven't enough ammo
      else {
        // priority first F35's
        for (int i = 0; i < airCrafts.size(); i++) {
          double temp = airCrafts.get(i).getMaxAmmo() - airCrafts.get(i).getAmmo();
          if ((airCrafts.get(i) instanceof F35) && (carrierAmmo >= temp)) {
            airCrafts.get(i).setAmmo(airCrafts.get(i).getMaxAmmo());
            carrierAmmo -= temp;
          } else if ((airCrafts.get(i) instanceof F35) && (carrierAmmo < temp)) {
            airCrafts.get(i).setAmmo(airCrafts.get(i).getAmmo() + carrierAmmo);
            carrierAmmo = 0;
          }
        }

        // priority secondly F16's
        for (int j = 0; j < airCrafts.size(); j++) {
          double temp = airCrafts.get(j).getMaxAmmo() - airCrafts.get(j).getAmmo();
          if ((airCrafts.get(j) instanceof F16) && (carrierAmmo >= temp)) {
            airCrafts.get(j).setAmmo(airCrafts.get(j).getMaxAmmo());
            carrierAmmo -= temp;
          } else if ((airCrafts.get(j) instanceof F16) && (carrierAmmo < temp)) {
            airCrafts.get(j).setAmmo(airCrafts.get(j).getAmmo() + carrierAmmo);
            carrierAmmo = 0;
          }
        }
      }
    } else {
      throw new Exception();
    }
  }

  static void fight(AircraftCarrier attacker, AircraftCarrier defender) {
    double sumAircraftDamage = totalDamage(attacker);
    if (defender.getHealthPoint() > sumAircraftDamage) {
      defender.setHealthPoint(defender.getHealthPoint() - sumAircraftDamage);
    } else {
      defender.setHealthPoint(0);
    }
  }

  static double totalDamage(AircraftCarrier aCc) {
    double sumAircraftDamage = 0;
    for (int i = 0; i < aCc.getAirCrafts().size(); i++) {
      sumAircraftDamage += aCc.getAirCrafts().get(i).getBaseDamage() * aCc.getAirCrafts().get(i).getAmmo();
    }
    return sumAircraftDamage;
  }

  public static String getStatus(AircraftCarrier aCc) {
    if (aCc.getHealthPoint() > 0) {
      String status =
          "HP: "
              + aCc.getHealthPoint()
              + ", Aircraft count: "
              + aCc.getAirCrafts().size()
              + " Ammo storage: "
              + aCc.getCarrierAmmo()
              + " Total damage: "
              + totalDamage(aCc)
              + "\nAircrafts: ";
      for (int i = 0; i < aCc.getAirCrafts().size(); i++) {
        status +=
            "\nType "
                + aCc.getAirCrafts().get(i).getType()
                + ", Ammo: "
                + aCc.getAirCrafts().get(i).getAmmo()
                + ", Base Damage: "
                + aCc.getAirCrafts().get(i).getBaseDamage()
                + ", All Damage: "
                + aCc.getAirCrafts().get(i).getAmmo() * aCc.getAirCrafts().get(i).getBaseDamage();
      }
      return status;
    } else {
      return "It's dead Jim :(";
    }
  }
}
