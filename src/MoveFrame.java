import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MoveFrame extends JFrame {

	public MoveFrame(String title) {
		this.setSize(200,100);;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		final int x = dm.width-10;
		System.out.println(x);
		this.setLocation(x,10);
		this.setVisible(true);
		final JFrame ins= this;
		this.setDefaultCloseOperation(3);
		Runnable run = new Runnable() {

			@Override
			public void run() {
				int srcX = x;
				for(int i =0; i<20; i++) {
					ins.setLocation(srcX-=10,10);
					try {
						Thread.sleep(50);
					} catch (Exception ef) {
					}
				}
			}
		};
		Thread t = new Thread(run);
		t.start();
	}
	
	public static void main(String[] args) {
		new MoveFrame("test move");

	}

}
