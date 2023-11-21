package thread1;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnableTest1 extends JFrame implements Runnable {
	Container pane;
	JLabel lbl = new JLabel("", JLabel.CENTER);
	ImageIcon icon;

	public RunnableTest1() {
		add("Center", lbl);
		pane = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		setVisible(true);
		Thread t = new Thread(this);
		t.start();
	}

	public static void main(String[] args) {
		new RunnableTest1();
	}

	@Override
	public void run() {
		String[] titles = { "첫", "두", "세", "네" };
		Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN };

		while (true) {
			for (int i = 0; i < colors.length; i++) {
				setTitle(titles[i] + "번째 화면");
				pane.setBackground(colors[i]);
				icon = new ImageIcon("imgs/large" + (i + 1) + ".jpg");
				lbl.setIcon(icon);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			setTitle("다섯번째 화면");
			pane.setBackground(Color.BLUE);
			icon = new ImageIcon("imgs/large5.jpg");
			lbl.setIcon(icon);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}