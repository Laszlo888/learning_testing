package aircraftCarrier;

public class Aircraft {
  private String type;
  private double ammo;
  private double maxAmmo;
  private double baseDamage;

  public double getAmmo() {
    return ammo;
  }

  public double getMaxAmmo() {
    return maxAmmo;
  }

  public double getBaseDamage() {
    return baseDamage;
  }

  public String getType() {
    return type;
  }

  public void setAmmo(double ammo) {
    this.ammo = ammo;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setBaseDamage(double baseDamage) {
    this.baseDamage = baseDamage;
  }

  public void setMaxAmmo(double maxAmmo) {
    this.maxAmmo = maxAmmo;
  }

  static double fight(Aircraft aircraft) {
    double temp = aircraft.getAmmo() * aircraft.getBaseDamage();
    aircraft.setAmmo(0);
    return temp;
  }

  static double refillAmmo(double fillAmmo, Aircraft aircraft) {
    double neededAmmo = aircraft.getMaxAmmo() - aircraft.getAmmo();
    if (fillAmmo >= neededAmmo) {
      aircraft.setAmmo(aircraft.getMaxAmmo());
      return fillAmmo - neededAmmo;
    } else {
      aircraft.setAmmo(aircraft.getAmmo() + fillAmmo);
      return 0;
    }
  }

  public String getStatus() {
    return "Type="
        + type
        + ", Ammo="
        + ammo
        + ", BaseDamage="
        + baseDamage
        + ", All Damage="
        + ammo * baseDamage;
  }

  boolean isPriority() {
    return false;
  }

  @Override
  public String toString() {
    return "Aircraft{" +
            "type='" + type + '\'' +
            ", ammo=" + ammo +
            ", maxAmmo=" + maxAmmo +
            ", baseDamage=" + baseDamage +
            '}';
  }
}
