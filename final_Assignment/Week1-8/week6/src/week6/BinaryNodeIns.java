package week6;


public class BinaryNodeIns {

	public static void main(String[] args) {
		NodeInsertion ins = new NodeInsertion();
		Nodes root = null;
		root = ins.insertion(root,8);
		root = ins.insertion(root,3);
		root = ins.insertion(root,24);
		root = ins.insertion(root,2);
		root = ins.insertion(root,0);
		root = ins.insertion(root,5);
		root = ins.insertion(root,9);
		System.out.println("Data is displayed in preorder traversal:");
		ins.preOrder(root);
	}

}
