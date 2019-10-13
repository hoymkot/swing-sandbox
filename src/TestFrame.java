import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class TestFrame extends JFrame {

	public TestFrame(String title) {
		super(title);
		this.setSize(300,300);
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillRect(this.getWidth()/2, this.getHeight()/2, 10, 10);
		g.drawString("NetJava", this.getWidth()/2, this.getHeight()/2);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
	}
	public static void main(String[] args) {
		new TestFrame("Test Windows Object Paint").setVisible(true);
		
	}

}
