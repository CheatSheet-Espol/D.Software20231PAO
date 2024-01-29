package PatronStrategy;

public class TransCiclistaEstrategia implements IEstrategiaDistribucion {
	
	@Override
	public void ejecutarDistribucion() {
		System.out.println("La distribución se realizará por medio de un ciclista");
	}

}
