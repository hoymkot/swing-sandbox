import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CustomerButton extends JButton {

	private Shape shape;
	
	public CustomerButton(String title) {
		super(title);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
		final JButton ins =this;
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseEntered ( MouseEvent e) {
				int x = ins.getLocation().x;
				int y = ins.getLocation().y;
				ins.setLocation(x+3,y+3);
			}
			
			public void mouseExited(MouseEvent e) {
				int x = ins.getLocation().x;
				int y = ins.getLocation().y;
				ins.setLocation(x-3,y-3);
			}
		});
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D dg = (Graphics2D)g;
		if (getModel().isArmed()) {
			dg.setPaint(new GradientPaint(0f,10f, Color.ORANGE, 50f,50f, Color.GREEN));
		} else {
			dg.setPaint(new GradientPaint(0f,10f, Color.GREEN, 50f,50f, Color.ORANGE));
		}
		
		dg.fillOval(0, 0, getSize().width-1, getSize().height-1);
		super.paintComponent(dg);
	}
	
	protected void paintBorder(Graphics g) {
//		super.paintBorder(g);
	}
	
	public boolean contains(int x, int y) {
		if ( shape == null || !shape.getBounds().equals(getBounds())) {
			shape  = new Ellipse2D.Float(0,0,getWidth(), getHeight());
		}
		return shape.contains(x,y);
	}
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Test Customized Button");
		JButton bu_login = new CustomerButton("Login" );
		JButton bu_reg = new CustomerButton("Regis" );
		frame.add(bu_login);
		frame.add(bu_reg);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(200,200);
		frame.setVisible(true);
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				JOptionPane.showMessageDialog(frame,  " what you click is " + command);
			}
			
		};
		bu_login.addActionListener(al);
		bu_reg.addActionListener(al);
	}
}
