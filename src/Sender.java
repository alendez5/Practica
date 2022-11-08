
public class Sender {

	
	public static void main(String args[]) {
		
		int length = 27;

		int bitsParidad = 0;
		int formula =   bitsParidad + length + 1;
		double potencia = Math.pow(2, bitsParidad);
		
		while ( potencia < formula) {
			
			
			bitsParidad++;
			
			formula =   bitsParidad + length + 1;
			potencia = Math.pow(2, bitsParidad);
			
		}
		
	
	
	}
}
