package thread1;

public class ThreadTest1 extends Thread {
	
	int cnt;
	
	public ThreadTest1(String name) {
		super(name);
	}
	
	public void run() {
		while (true) {
			System.out.println(getName() + "=> "+ ++cnt);
			try {
				sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	
	
public static void main(String[] args) {
	ThreadTest1 t1 = new ThreadTest1("First");
	ThreadTest1 t2 = new ThreadTest1("second");
	t1.start();
	t2.start();
}
}
