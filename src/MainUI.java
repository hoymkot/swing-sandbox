import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MainUI extends JFrame {
	public static void main(String[] args) {
		MainUI mu = new MainUI();
		NetConnector connector = new NetConnector();
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("root node");
		DefaultTreeModel dm = new DefaultTreeModel(rootNode);
		NetJavaTree tree = new NetJavaTree();
		tree.setModel(dm);
		connector.addListener(tree);
		NetJavaButton button = new NetJavaButton();
		connector.addListener(button);
		mu.setupUI(tree, button);
		connector.start();
		
	}
	
	private void setupUI(JTree tree, JButton button) {
		this.setTitle("Test UI");
		FlowLayout fl = new FlowLayout();
		this.setLayout(fl);
		this.add(tree);
		this.add(button);
		this.setSize(200,400);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		
	}

	private NetConnector connector;
	private DefaultMutableTreeNode rootNode;
	private JTree tree;
}
