package aircraftCarrier;

public class F35 extends Aircraft {

  public F35() {
    super.setType("F35");
    super.setAmmo(0);
    super.setMaxAmmo(12);
    super.setBaseDamage(50);
  }

  @Override
  boolean isPriority() {
    return true;
  }
}
