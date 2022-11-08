
public class Sender {

	
	public static void main(String args[]) {
		
		int[] mensaje = {1,1,1,1,1,1,1,1};

		int bitsParidad = 0;
		int formula =  bitsParidad + mensaje.length + 1;
		double potencia = Math.pow(2, bitsParidad);
		
		while ( potencia < formula) {
			
			
			bitsParidad++;
			
			formula =   bitsParidad + mensaje.length + 1;
			potencia = Math.pow(2, bitsParidad);
			
		}
		
		int[] codigoHamming = new int[formula];
		int contador = 0;
		
		
		for(int i = 1; i < codigoHamming.length;i++) {
			
			if(!esPotenciaDeDos(i)) {
				
				codigoHamming[i] = mensaje[contador];
				contador++;
				
			}
			
		}
		
	
		
		
		
	}
	
	private static boolean esPotenciaDeDos(int posicion) {
		
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
