package pokeBattle;

public enum DamageType
{
  NONE, NOT_EFFECTIVE, NORMAL, SUPER_EFFECTIVE;
  
  private double modifier_;
  
  static {
    NONE.modifier_ = 0.0;
    NOT_EFFECTIVE.modifier_ = 0.5;
    NORMAL.modifier_ = 1.0;
    SUPER_EFFECTIVE.modifier_ = 2.0;
  }
  
  @Override
  public String toString()
  {
    return switch(this)
    {
    case NONE -> "has NO effect!";
    case NOT_EFFECTIVE -> "is not very effective.";
    case NORMAL -> "is effective.";
    case SUPER_EFFECTIVE -> "is SUPER effective!";
    };
  }
  
  public double getModifier()
  {
    return modifier_;
  }
}
