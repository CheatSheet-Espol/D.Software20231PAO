package juego;

public class Juego{

  private int maxRounds;
  private int draw;
  private Player player1;
  private Player player2;
  
  public Juego(Player p1, Player p2, int rounds){
    this.player1 = p1;
    this.player2 = p2;
    this.draw = 0;
    this.maxRounds = rounds;
  }

  public static void launch(){
     int rounds = 0;
      while(round < maxRounds){

            round();
        
          if(player1.wins - player2.wins > 3){
              System.out.println("gano el jugador 1");
              break;
          } if(player2.wins - player1.wins > 3){
              System.out.println("gano el jugador 2");
              break;
          }

      }
    
  }

  private void round(){
      String choice1 = player1.playerChoice();
      String choice2 = player2.playerChoice();
      boolean victory1 = choice1.equals("paper") && choice2.equals("rock");
      boolean victory2 = choice1.equals("rock") && choice2.equals("scissor");
      boolean victory3 = choice1.equals("scissor") && choice2.equals("paper");
    
      if(victory1 || victory2 || victory3) player1.wins++;
      else if (!victory1 && !victory2 && !victory3) player2.wins++;
      else draw++;
  }

}
