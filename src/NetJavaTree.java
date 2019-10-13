import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

public class NetJavaTree extends JTree implements IMsgReceiverListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void receiveMsg(Msg m) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.getModel().getRoot();
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(m);
		root.add(newNode);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
