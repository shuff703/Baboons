
public class Baboon extends Thread{
	public Direction d;
	
	public static Rope rope = new Rope(7);
	
	public Baboon(){
		int ind = (int) (Math.random() * 2);
		if(ind == 0){
			d = Direction.left;
		}
		else {
			d = Direction.right;
		}
	}
	public void switchDireciton(){
		if(this.d == Direction.left){
			this.d = Direction.right;
		} else {
			this.d = Direction.left;
		}
	}
	@Override
	public void run() {
		while(true){
			if(this.d == Rope.direction){
				try {
					rope.acquire();
					Thread.sleep(20);
					rope.release();
					this.switchDireciton();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else if(Rope.direction == Direction.none){
				Rope.direction = this.d;
				try {
					rope.acquire();
					Thread.sleep(20);
					rope.release();
					this.switchDireciton();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				run();
			}
		}
		
	}
}
