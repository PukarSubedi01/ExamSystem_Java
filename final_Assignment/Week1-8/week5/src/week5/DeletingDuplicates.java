package week5;

public class DeletingDuplicates {
	 class Node{
	        int data;
	        Node next;

	        public Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }
	    
	    public Node head = null;
	    public Node tail = null;
	    
	    public void addNode(int data) {
	        Node newNode = new Node(data);
	        if(head == null) {
	            head = newNode;
	            tail = newNode;
	        }
	        else {
	            tail.next = newNode;
	            tail = newNode;
	        }
	    }
	    public void removeDuplicate() {
	        Node current = head, index = null, temp = null;
	        if(head == null) {
	            return;
	        }
	        else {
	            while(current != null){
	                temp = current;
	                index = current.next;

	                while(index != null) {
	                    if(current.data == index.data) {
	                        temp.next = index.next;
	                    }
	                    else {
	                        temp = index;
	                    }
	                    index = index.next;
	                }
	                current = current.next;
	            }
	        }
	    }
	    public void display() {
	        Node current = head;
	        if(head == null) {
	            System.out.println("List is empty");
	            return;
	        }
	        while(current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        DeletingDuplicates List = new DeletingDuplicates();

	        //Adds data to the list  
	       List.addNode(10);
	       List.addNode(21);
	       List.addNode(21);
	       List.addNode(10);
	       List.addNode(1);
	       List.addNode(2);
	       List.addNode(3);

	        System.out.println("List before deleting duplicates ");
	       List.display();
	       List.removeDuplicate();
	        System.out.println("List after removing duplicates: ");
	       List.display();
	    }
	
}
