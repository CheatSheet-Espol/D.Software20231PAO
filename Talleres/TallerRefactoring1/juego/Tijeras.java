public class Tijeras extends Opcion{

    private Opcion debilidad= new Roca();
    private Opcion vence=     new Papel();
    @Override
    public String toString(){
        return "Tijeras";
    }
}