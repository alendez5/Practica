
public class Sender {

	
	public static void main(String args[]) {
		
		int[] mensaje = {1,1,1,1,1,1,1,1};

		int bitsParidad = 0;
		int longitudTotal =  bitsParidad + mensaje.length + 1;
		double potencia = Math.pow(2, bitsParidad);
		
		while ( potencia < longitudTotal) {
			
			
			bitsParidad++;
			
			longitudTotal =   bitsParidad + mensaje.length + 1;
			potencia = Math.pow(2, bitsParidad);
			
		}
		
		int[] codigoHamming;
		
		
		codigoHamming = introducirBitsDeDatos(mensaje, longitudTotal); 
	
		
		codigoHamming = introducirBitsDeRedundancia(codigoHamming); 
		

		int contador = 0;
	
		
		for(int i = 1;  i < codigoHamming.length;i++) {
			
			if(codigoHamming[i] == 1)
				contador++;
			
		}
		
		if(contador % 2 == 0) {       //Se introduce el bit de paridad global
			codigoHamming[0] = 0;
		}
		else {
			codigoHamming[0] = 1;
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
	
	private static int[] introducirBitsDeDatos(int[] mensaje, int longitud) {
		
		int[] codigoHamming = new int[longitud];
		
		
		int contador = 0;//Se usa solo para recorrer el array del mensaje
		
		
		for(int i = 1; i < codigoHamming.length;i++) {
			
			if(!esPotenciaDeDos(i)) {
				
				codigoHamming[i] = mensaje[contador];
				contador++;
				
			}
			
		}
		
		return codigoHamming;
		
	}
	
	
	private static int[] introducirBitsDeRedundancia(int[] codigoHamming) {
		
		int sumaDeBits = 0; // Se usa solo para sumar los bits que corresponden a cada bit de redundancia
		
		
		for (int i = 1; i < codigoHamming.length; i++) {

			if (esPotenciaDeDos(i)) {
				
				for (int j = 1; j < codigoHamming.length; j++) {

					if (j != i && !esPotenciaDeDos(j)) {

						if ((j & i) != 0) {
						
							if (codigoHamming[j] == 1)
								sumaDeBits++;

						}

					}

				}

				if (sumaDeBits % 2 != 0)
					codigoHamming[i] = 1;
				else
					codigoHamming[i] = 0;
				
				
				
				sumaDeBits = 0; // Se resetea la suma
			}

		}
		
		return codigoHamming;
		
	}
	
	
	
}
