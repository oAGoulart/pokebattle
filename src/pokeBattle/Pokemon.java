package pokeBattle;

public final class Pokemon
{
  private static final int minHealth_ = 10;
  private String name_;
  private PokemonType type_;
  private int health_;
  
  Pokemon(String name, PokemonType type, int health)
  {
    name_ = name;
    type_ = type;
    health_ = Math.max(health, minHealth_);
    System.out.printf(name_ + " created with %d health\n", health_);
  }
  
  @Override
  public String toString()
  {
    return name_;
  }
  
  private void calculateDamage_(Pokemon attacker, int baseDamage)
  {
    DamageType damageType = attacker.type_.getDamageType(type_);
    double modifier = damageType.getModifier();
    int damage = (int)(baseDamage * modifier);
    health_ -= damage;
    health_ = Math.max(health_, 0);
    System.out.printf(attacker + " attacks " + this + " for %d damage...\n", baseDamage);
    System.out.println("Attack " + damageType);
    System.out.printf(this + " receives %d damage!\n", damage);
  }
  
  public void attack(Pokemon defender)
  {
    final int defaultAttack = 3;
    defender.calculateDamage_(this, defaultAttack);
  }
  
  public boolean hasBeenDefeated()
  {
    if (health_ == 0)
    {
      System.out.println(this + " has been defeated!");
      return true;
    }
    return false;
  }
  
  public void status()
  {
    System.out.printf(name_ + " health: %d\n", health_);
  }
}
