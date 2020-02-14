package week7;

import java.util.LinkedList;
import java.util.Queue;


public class UndirectedGraph {
	 private int size=10;
	    private Ver Vertices[];
	    private int adjMatrix[][];
	    private int nVertices;
	    private Queue<Integer> q;
	    
	    class Ver
	    {
	        char label;
	        boolean wasVisited;
	        
	        Ver(char lbl)
	        {
	            this.label=lbl;
	            this.wasVisited=false;
	        }
	    }
	    
	    UndirectedGraph(){
	        Vertices=new Ver[size];
	        adjMatrix=new int[size][size];
	        nVertices=0;
	        q=new LinkedList<Integer>();
	    }
	    
	    public void addVertex(char a)
	    {
	        Vertices[nVertices++]=new Ver(a);
	    }
	    
	    public void addEdge(int start, int end)
	    {
	        adjMatrix[start][end]=1;
	        adjMatrix[end][start]=1;
	    }
	    
	    public void display(int a)
	    {
	        System.out.print(Vertices[a].label);
	    }
	    public int getNeighbour(int a)
	    {
	        for(int i=0; i<nVertices; i++)
	        {
	            if(adjMatrix[a][i]==1 && Vertices[i].wasVisited==false)
	            {
	                return i;
	            }
	        }
	        
	        return -1;
	    }
	    
	    public void breadth()
	    {
	        Vertices[0].wasVisited=true;
	        display(0);
	        q.add(0);
	        int v2;
	        
	        while(!q.isEmpty())
	        {
	            int v1=q.remove();
	            while((v2=getNeighbour(v1))!=-1)
	            {
	                Vertices[v2].wasVisited=true;
	                display(v2);
	                q.add(v2);
	            }
	        }
	    }
 
 
 public static void main(String[] args) {
     
     UndirectedGraph graph=new UndirectedGraph();
	        graph.addVertex('P');
	        graph.addVertex('U');
	        graph.addVertex('K');
	        graph.addVertex('A');
	        graph.addVertex('R');
	        
	        graph.addEdge(0,1);
	        graph.addEdge(1,2);
	        graph.addEdge(0,3);
	        graph.addEdge(2,4);
	        graph.addEdge(1,3);
	        
	        System.out.println("Displaying graph from bfs");
	        
	        graph.breadth();
 }
}
