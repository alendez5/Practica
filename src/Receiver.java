
public class Receiver {
	
	private int[] codigoHamming;
	
	public Receiver(int codigoHamming[]) {
		
		this.codigoHamming = codigoHamming;
		
	}

	

	public void buscarErrores() {
		
		int unError = buscarUnSoloError();
		
		if(buscarDosErrores())
			System.out.println("Existen 2 errores en el codigo");
		else if(!buscarDosErrores() && unError != 0)
			System.out.println("Existe un error en la posicion " + unError);
		else
			System.out.println("No existen errores en el codigo");
		
	}
	
	private int buscarUnSoloError() {
		
		
		int contadorDeBits = 0;
		int sumaDePosiciones = 0; // Es el valor que retorna la funcion, es la suma de las posiciones de bits de redundancia, para saber donde está el error
		
		for (int posBitRedundancia = 1; posBitRedundancia < codigoHamming.length; posBitRedundancia++) {

			if (esPotenciaDeDos(posBitRedundancia)) {

				for (int posBitMensaje = 1; posBitMensaje < codigoHamming.length; posBitMensaje++) {

					if (posBitMensaje != posBitRedundancia && !esPotenciaDeDos(posBitMensaje)) {

						if ((posBitMensaje & posBitRedundancia) != 0) {

							if (codigoHamming[posBitMensaje] == 1) {
								contadorDeBits++;
							}

						}

					}

				}
				
				if(contadorDeBits % 2 == 0 && codigoHamming[posBitRedundancia] == 1) {
					sumaDePosiciones += posBitRedundancia;
				}																//En ambos casos, si hay un error en 1 bit de mensaje, voy sumando las posiciones
				else if(contadorDeBits % 2 != 0 && codigoHamming[posBitRedundancia] == 0) { 
					sumaDePosiciones += posBitRedundancia;
				}

			}
			
			contadorDeBits = 0;

		}
		
		
		
		return sumaDePosiciones;
		
	}

	private boolean buscarDosErrores() {
		
		boolean dosErrores = false;
		
		if(buscarUnSoloError() != 0) {
			
				if(comprobarBitGlobal()) {
					
					dosErrores = true;
					
				}
			
		}
			
		return dosErrores;
	}
	
	private  boolean comprobarBitGlobal() {

		int contador = 0;
		boolean esCorrecto = false;
		
		for (int i = 1; i < codigoHamming.length; i++) {

			if (codigoHamming[i] == 1)
				contador++;

		}

		if (contador % 2 == 0 && codigoHamming[0] == 0) {
			esCorrecto = true;
		} 													
		else if(contador % 2 != 0 && codigoHamming[0] == 1) {
			esCorrecto = true;
		}

		return esCorrecto;

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
