import javax.swing.JButton;

public class NetJavaButton extends JButton implements IMsgReceiverListener {
	public void receiveMsg(Msg m) {
		this.setText(m.getContent());
	}
}
