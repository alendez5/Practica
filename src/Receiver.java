
public class Receiver {
	
	private int[] codigoHamming;
	
	public Receiver(int codigoHamming[]) {
		
		this.codigoHamming = codigoHamming;
		
	}

	

	
	private  boolean esPotenciaDeDos(int posicion) {
		
		boolean esPotencia = true;
		
		if(posicion == 0)
			esPotencia = false;
		else if(posicion == 1)
			esPotencia = true;
		
		else {
			
			while(posicion >= 2) {
			
				if(posicion %2 != 0)
					esPotencia = false;
				
				posicion /= 2;
				
			}
			
		}			
	  
		return esPotencia;
		
	}
}
