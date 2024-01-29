package PatronStrategy;

public class ContextoDistribucion  {
	private IEstrategiaDistribucion estrategia;
	
	public ContextoDistribucion (IEstrategiaDistribucion estrategia) {
		this.estrategia = estrategia;
	}
	
	public void setEstrategia(IEstrategiaDistribucion estrategia) {
		
		this.estrategia = estrategia;
		
		
	}
	
	
	public void ejecutarEstrategiaDistribucion() {
		
		this.estrategia.ejecutarDistribucion();
		
		
	}
	
	
}