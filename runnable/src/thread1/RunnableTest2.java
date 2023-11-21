package thread1;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnableTest2 extends JFrame implements Runnable {
	JLabel lbl = new JLabel("", JLabel.CENTER);
	
	public RunnableTest2() {
		
		add("Center", lbl);
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,200,300,200);
		setVisible(true);
		Thread t= new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		Calendar calendar = null;
		while(true) {
			calendar = Calendar.getInstance();
			int h = calendar.get(Calendar.HOUR_OF_DAY);
			int m = calendar.get(Calendar.MINUTE);
			int s = calendar.get(Calendar.SECOND);
			lbl.setText(h +"시" +m+ "분"+s+ "초");  
			try { 
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
