
/*Esta clase para hacer 'Extract class'
Porque un juego tiene un ganador, conoce sus empates y tiene la condicion de cuando debe terminar

*/
public class Match {
    private int roundsPlayed=0;
    private int draws=0;
    private PlayerRefactored p1;
    private PlayerRefactored p2;
    private final int  juegosParaGanar=3;
    public boolean condicionFinJuego;
    
    public Match(PlayerRefactored p1,PlayerRefactored p2){
        this.p1=p1;
        this.p2=p2;
    }
    
    public void mostrarEncabezado(){
        System.out.println("*********Round: "+roundsPlayed+ " *********\n");
        System.out.println("Numero de empates: "+draws);
        
        System.out.println("Player1: "+p1.playerChoice().toString());
        System.out.println("Player2: "+p2.playerChoice().toString());
        condicionFinJuego= (this.p1.getWins()>=juegosParaGanar || this.p2.getWins()>=juegosParaGanar);
    }
    

}
