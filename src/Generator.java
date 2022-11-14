import java.util.Random;

public class Generator {
	
	private int[] mensaje;
	private final int LONGITUD = 8;
	
	public Generator() {
		
		crearMensaje();
		
	}
	
	private void crearMensaje() {
		
		   Random random= new Random();
	       int N = 10;
	       int randomNumber;
	       int max = 1, min = 0;
	          
	       mensaje = new int[LONGITUD];
	       
	       for(int i = 0; i < N;i++){
	              
	                       
	    	   	randomNumber = random.nextInt((max - min) + 1) + min;
	                 
	            mensaje[i] = randomNumber;        
	  
	          
	       }
	       
	}
	
	public int[] getMensaje() {
		
		return mensaje;
		
	}
	
	

}
