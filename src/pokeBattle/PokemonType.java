package pokeBattle;

import java.util.EnumMap;
import java.util.Map;

public enum PokemonType
{
  NORMAL, FIRE, WATER, GRASS, GROUND;
  
  private Map<PokemonType, DamageType> effectiveness_;
  
  private void setEffectiveness_(PokemonType target, DamageType effect)
  {
    effectiveness_.put(target, effect);
  }
  
  static {
    for (PokemonType type : values()) {
      type.effectiveness_ = new EnumMap<>(PokemonType.class);
    }
    
    FIRE.setEffectiveness_(FIRE, DamageType.NOT_EFFECTIVE);
    FIRE.setEffectiveness_(WATER, DamageType.NOT_EFFECTIVE);
    FIRE.setEffectiveness_(GRASS, DamageType.SUPER_EFFECTIVE);
    
    WATER.setEffectiveness_(FIRE, DamageType.SUPER_EFFECTIVE);
    WATER.setEffectiveness_(WATER, DamageType.NOT_EFFECTIVE);
    WATER.setEffectiveness_(GRASS, DamageType.NOT_EFFECTIVE);
    WATER.setEffectiveness_(GROUND, DamageType.SUPER_EFFECTIVE);
    
    GRASS.setEffectiveness_(FIRE, DamageType.NOT_EFFECTIVE);
    GRASS.setEffectiveness_(WATER, DamageType.SUPER_EFFECTIVE);
    GRASS.setEffectiveness_(GRASS, DamageType.NOT_EFFECTIVE);
    GRASS.setEffectiveness_(GROUND, DamageType.SUPER_EFFECTIVE);
    
    GROUND.setEffectiveness_(FIRE, DamageType.SUPER_EFFECTIVE);
    GROUND.setEffectiveness_(GRASS, DamageType.NOT_EFFECTIVE);
  }
  
  public DamageType getDamageType(PokemonType defender)
  {
    return effectiveness_.getOrDefault(defender, DamageType.NORMAL);
  }
}
