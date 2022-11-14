
public class Noise {
	
	private int[] codigoHamming;
	
	public Noise(int[] codigoHamming) {
		
		this.codigoHamming = codigoHamming;
		
		
		
		System.out.println(" Hay " + alterarCodigo() + " modificaciones");
		
	}

	private boolean prob(double prob) {
		return Math.random() < prob;
	}
	
	private int alterarCodigo(){
		
		int contadorModificaciones = 0;
		double valorProb = 0.1;
		
		for(int i = 0; i < codigoHamming.length;i++) {
			
			if(prob(valorProb) && contadorModificaciones < 2) {
				
				if(codigoHamming[i] == 1)
					codigoHamming[i] = 0;
				
				else if(codigoHamming[i] == 0)
					codigoHamming[i] = 1;
				
				
				contadorModificaciones++;
				
			}
			
		}
		
		return contadorModificaciones;
		
	} 

	
	public int[] getCodigoHamming() {
		return codigoHamming;
	}
}
