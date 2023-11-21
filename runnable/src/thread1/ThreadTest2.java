package thread1;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTest2 extends JFrame {
	Container pane;
	JLabel lbl = new JLabel("",JLabel.CENTER);
	ImageIcon icon;
	
	public ThreadTest2() {
		add("Center",lbl);
		pane = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		setVisible(true);
		ChangeThread t = new ChangeThread();
		t.start();
	}
	
	class ChangeThread extends Thread{
		String[] titles = {"첫","두","세","네"};
		Color[] colors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN};
				
		public void run() {
			for (int i = 0; i < colors.length; i++) {
				setTitle(titles[i]+"번째 화면");
				pane.setBackground(colors[i]);
				icon = new ImageIcon("imgs/large"+(i+1)+".jpg");
				lbl.setIcon(icon);
				
				try {
					sleep(20);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
					
			}
			//end for
			setTitle("다섯번째 화면");
			pane.setBackground(Color.BLUE);
			icon = new ImageIcon("imgs/large5.jpg");
			lbl.setIcon(icon);
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
				
			
			
		
				}
		}
	

	public static void main(String[] args) {
		new ThreadTest2();

	}

}