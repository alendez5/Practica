
public class Sender {

	private int[] codigoHamming;
	private int[] mensaje;
	
	public Sender(int[] mensaje) {
		
		this.mensaje = mensaje;
		

		crearCodHamming();
		
	}
	
	
	private void crearCodHamming() {
		
		int bitsParidad = 0;
		int longitudTotal =  bitsParidad + mensaje.length + 1;
		double potencia = Math.pow(2, bitsParidad);
		
		while ( potencia < longitudTotal) {
			
			bitsParidad++;
			
			longitudTotal =   bitsParidad + mensaje.length + 1;
			potencia = Math.pow(2, bitsParidad);
			
		} // El objetivo del while solo es calcular la longitud total del codigoHamming
		
		
		codigoHamming = new int[longitudTotal];
		
		introducirBitsDeDatos(); 
	
		
		introducirBitsDeRedundancia(); 
		
		
		introducirBitGlobal();
	
		
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
	
	private void introducirBitsDeDatos() {
		
		
		
		int contador = 0;//Se usa solo para recorrer el array del mensaje
		
		
		for(int i = 1; i < codigoHamming.length;i++) {
			
			if(!esPotenciaDeDos(i)) {
				
				codigoHamming[i] = mensaje[contador];
				contador++;
				
			}
			
		}
		
		
	}
	
	
	private void introducirBitsDeRedundancia() {
		
		int sumaDeBits = 0; // Se usa solo para sumar los bits que corresponden a cada bit de redundancia
		
		
		for (int posBitRedundancia = 1; posBitRedundancia < codigoHamming.length; posBitRedundancia++) {

			if (esPotenciaDeDos(posBitRedundancia)) {
				
				for (int posBitMensaje = 1; posBitMensaje < codigoHamming.length; posBitMensaje++) {

					
					if (posBitMensaje != posBitRedundancia && !esPotenciaDeDos(posBitMensaje)) {
						
						if ((posBitMensaje & posBitRedundancia) != 0) {
							
							if (codigoHamming[posBitMensaje] == 1)
								sumaDeBits++;

						}

					}

				}

				if (sumaDeBits % 2 != 0)
					codigoHamming[posBitRedundancia] = 1;
				else
					codigoHamming[posBitRedundancia] = 0;
				
				
				
				sumaDeBits = 0; // Se resetea la suma
			}

		}
		
		
	}
	
	
	private void introducirBitGlobal() {
		
		
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
	
	public int[] getCodigoHamming() {
		return codigoHamming;
	}
	
}
