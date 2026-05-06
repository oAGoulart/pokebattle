package pokebattle;

import java.util.Scanner;

public final class PokeBattle
{
  private static final Scanner scan_ = new Scanner(System.in);
  private static final Pokemon mine_ = new Pokemon("TechTudo", PokemonType.WATER, 16);
  private static final Pokemon opponent_ = new Pokemon("Charmander", PokemonType.FIRE, 16);
  private static int rounds_ = 0;
  private static String result_ = "TIE";
  
  private static boolean myTurn()
  {
    System.out.print("YOUR TURN: ");
    String action = scan_.nextLine();
    switch(action)
    {
    case "attack" -> {
      mine_.attack(opponent_);
      if (opponent_.hasBeenDefeated())
      {
        result_ = "WON";
        return false;
      }
    }
    case "escape" -> {
      System.out.println("You ran away from the battle!");
      result_ = "ESCAPED";
      return false;
    }
    default -> System.out.println("You have skipped your turn.");
    }
    return true;
  }
  
  private static boolean opponentTurn()
  {
    opponent_.attack(mine_);
    if (mine_.hasBeenDefeated())
    {
      result_ = "LOST";
      return false;
    }
    return true;
  }

  public static void main(String[] args)
  {
    try (scan_)
    {
      System.out.println("  === BATTLE START ===");
      while(true)
      {
        rounds_++;
        System.out.printf("  === ROUND %d ===\n", rounds_);
        mine_.status();
        opponent_.status();
        if (!myTurn())
          break;
        if (!opponentTurn())
          break;
      }
      System.out.println("  === BATTLE END ===");
      System.out.printf("Total rounds: %d\n", rounds_);
      System.out.println("Result: " + result_);
    }
  }
}