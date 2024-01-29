package PatronStrategy;

public class ContextoDistribucion implements IEstrategiaDistribucion {
	private IEstrategiaDistribucion estrategia;
	
	public ContextoDistribucion (IEstrategiaDistribucion estrategia) {
		this.estrategia = estrategia;
	}
	
	public void setEstrategia(IEstrategiaDistribucion estrategia) {
		
		this.estrategia = estrategia;
		
		
	}
	
	@Override
	public void ejecutarDistribucion() {
		
		this.estrategia.ejecutarDistribucion();
		
		
	}
	
	
}