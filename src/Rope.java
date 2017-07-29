import java.util.concurrent.Semaphore;

public class Rope extends Semaphore{
	public Rope(int permits) {
		super(permits);
		// TODO Auto-generated constructor stub
		Rope.monkeysOnRope = 0;
		Rope.direction = Direction.none;
	}
	private static final long serialVersionUID = 1L;

	public static Direction direction;
	
	public static int monkeysOnRope;
	
	
	@Override
	public void acquire(){
		synchronized (this){
			Rope.monkeysOnRope++;
			System.out.println("Acquiring rope moving " + Rope.direction.toString() + 
					"with " + Rope.monkeysOnRope + " on rope.");
		}
	}
	
	public void release(){
		synchronized (this){
			Rope.monkeysOnRope--;
			if(Rope.monkeysOnRope == 0){
				Rope.direction = Direction.none;
			}
		}
	}
	
}
