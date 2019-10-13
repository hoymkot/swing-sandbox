import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class NetConnector extends Thread {
	public void run() {
		int t = 0;
		while (true) {
			try {
				Thread.sleep(3000);

			} catch (Exception ef) {
				ef.printStackTrace();

			}
			t++;
			Msg m = new Msg();
			m.setId(t);
			m.setContent("message " + t);
			System.out.println("receive a message: " + m.toString());
			fireMsgReceive(m);
		}
	}
	
	private void fireMsgReceive(Msg m) {
		for (IMsgReceiverListener it : listeners) {
			it.receiveMsg(m);
		}
		
	}
	
	public void addListener(IMsgReceiverListener listener) {
		listeners.add(listener);
	}

	private List<IMsgReceiverListener> listeners = new ArrayList<IMsgReceiverListener>();
	private DefaultMutableTreeNode rootNode;
	public NetConnector() {
	}
	
	
}
