package week6;

public class NodeInsertion {

	public Nodes createNewNode(int value) {
		Nodes nd = new Nodes();
		nd.data=value;
		nd.left=null;
		nd.right=null;
		return nd;
		
	}
	public Nodes insertion(Nodes node, int val) {
		if (node == null) {
			return createNewNode(val);	
		}
		if(val < node.data) {
			node.left = insertion(node.left, val);
		}
		else if (val>node.data) {
			node.right = insertion(node.right, val);    
		}
		return node;
	}
	public void preOrder(Nodes node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

}
