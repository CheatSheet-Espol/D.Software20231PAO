import java.util.Random;

public class PlayerRefactored {
    int wins;


    public Opcion playerChoice(){
        final Opcion[] opciones= {new Roca(), new Papel(), new Tijeras()};

        int indexAleatorio= new Random().nextInt(opciones.length);
        return (Opcion)opciones[indexAleatorio];
    }

    public void setWins(){
        wins++;
    }
    public int getWins(){
        return wins;
    }
    
    
}
