
public class Sender {

	
	public static void main(String args[]) {
		
		int[] mensaje = {1,1,1,1,1,1,1,1};
		int[] codigoHamming;
		
		int bitsParidad = 0;
		int longitudTotal =  bitsParidad + mensaje.length + 1;
		double potencia = Math.pow(2, bitsParidad);
		
		while ( potencia < longitudTotal) {
			
			bitsParidad++;
			
			longitudTotal =   bitsParidad + mensaje.length + 1;
			potencia = Math.pow(2, bitsParidad);
			
		}

		
		
		codigoHamming = introducirBitsDeDatos(mensaje, longitudTotal); 
	
		
		codigoHamming = introducirBitsDeRedundancia(codigoHamming); 
		
		
		codigoHamming = introducirBitGlobal(codigoHamming);
	
		
		auxImprimirCodigo(codigoHamming); // Funcion auxiliar temporal para imprimir codigo
	
		
		
		System.out.println();
		
		Receiver receiver = new Receiver(codigoHamming);
		
		int posicion = receiver.buscarUnSoloError();
		
		System.out.println(posicion);
		
		if(receiver.buscarDosErrores())
			System.out.println("Hay 2 errores");
		
		
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
		
		return codigoHamming;
		
	}
	
	
	private static int[] introducirBitGlobal(int[] codigoHamming) {
		
		
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
		
		
		
		return codigoHamming;
		
	}
	
	private static void auxImprimirCodigo(int[] codigoHamming) {
		 
		for (int i = 0; i < codigoHamming.length; i++) { //Imprime bits
			System.out.print(codigoHamming[i] + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < codigoHamming.length; i++) { // Imprime posiciones
			System.out.print(i + " ");
		
		}
	}
	
}
