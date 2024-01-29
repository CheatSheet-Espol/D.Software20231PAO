package PatronStrategy;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("DEMO: Strategy");
        //Se elije el medio de transporte
        ContextoDistribucion distribucion = new ContextoDistribucion(new TransCiclistaEstrategia());
        distribucion.ejecutarEstrategiaDistribucion();
        System.out.println("cambio de estrategia:");
           //Si se desea 
		  //se pueden cambiar las vías de transporte al momento de ejecución del programa 
		distribucion.setEstrategia(new TransAutomotrizEstrategia());

		distribucion.ejecutarEstrategiaDistribucion();
        System.out.println("");
    }
}
