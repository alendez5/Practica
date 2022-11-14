
public class Main {
	
	public static void main(String args[]) {
		
		int[] mensaje;
		int[] codigoHamming;
		
		
		
		Generator generator = new Generator();
		mensaje = generator.getMensaje();
	
		
		
		Sender sender = new Sender(mensaje);
		codigoHamming = sender.getCodigoHamming();
		
	
		
		
		Noise noise = new Noise(codigoHamming);
		codigoHamming = noise.getCodigoHammingModificado();
		
		
		noise.mostrarModificaciones();
		
		
		Receiver receiver = new Receiver(codigoHamming);
		receiver.buscarErrores();
		
	}

	
	private static void auxImprimirCodigo(int[] array) {
		 

		System.out.println();
		
		System.out.print("Array:        ");
		for (int i = 0; i < array.length; i++) { //Imprime bits
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		
		System.out.print("Posiciones:   ");
		for (int i = 0; i < array.length; i++) { // Imprime posiciones
			System.out.print(i + " ");
		
		}
		
		System.out.println();
		
	}
}
