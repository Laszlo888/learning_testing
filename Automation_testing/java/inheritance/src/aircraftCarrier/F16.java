package aircraftCarrier;

public class F16 extends Aircraft {

  public F16() {
    super.setType("F16");
    super.setAmmo(0);
    super.setMaxAmmo(8);
    super.setBaseDamage(30);
  }

  @Override
  boolean isPriority() {
    return false;
  }
}
