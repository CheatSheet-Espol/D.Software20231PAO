public class Papel extends Opcion{
    private Opcion debilidad= new Tijeras();
    private Opcion vence=     new Roca();
    @Override
    public String toString(){
        return "Papel";
    }
}