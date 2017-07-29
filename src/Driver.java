
public class Driver {
	
	public static void main(String [] args) throws InterruptedException{
		System.out.println("Soemthing happened");
		for(int i = 0; i<100; i++){
			System.out.println("Sned");
			new Baboon().start();
		}
	}
}
