package pokebattle;

public enum DamageType
{
  NONE, NOT_EFFECTIVE, NORMAL, SUPER_EFFECTIVE;
  
  private double modifier_;
  
  static {
    NONE.setModifier_(0.0);
    NOT_EFFECTIVE.setModifier_(0.5);
    NORMAL.setModifier_(1.0);
    SUPER_EFFECTIVE.setModifier_(2.0);
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
  
  private void setModifier_(double value)
  {
    modifier_ = value;
  }
}
