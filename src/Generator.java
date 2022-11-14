import java.util.Random;

public class Generator {
	
	private int[] mensaje;
	private final int LONGITUD_MENSAJE = 10;
	
	public Generator() {
		
		crearMensaje();
		
	}
	
	private void crearMensaje() {
		
		   Random random= new Random();
	  
	       int randomNumber;
	       int max = 1, min = 0;
	          
	       mensaje = new int[LONGITUD_MENSAJE];
	       
	       for(int i = 0; i < LONGITUD_MENSAJE ;i++){
	              
	                       
	    	   	randomNumber = random.nextInt((max - min) + 1) + min;
	                 
	            mensaje[i] = randomNumber;        
	  
	          
	       }
	       
	}
	
	public int[] getMensaje() {
		
		return mensaje;
		
	}
	
	

}
