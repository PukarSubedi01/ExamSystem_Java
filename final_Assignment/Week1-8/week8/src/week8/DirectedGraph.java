package week8;

import java.util.Stack;

public class DirectedGraph {
	private final int size=20;
	private Vertex Vertices[];
	private int adjMatrix[][];
	private int nVertices=0;
	private Stack<Integer> s;
	
	class Vertex
	{
		char label;
		boolean wasVisited;
		
		Vertex(char lbl)
		{
			this.label=lbl;
			this.wasVisited=false;
		}
	}
	
	DirectedGraph()
	{
		Vertices=new Vertex[size];
		adjMatrix=new int[size][size];
		nVertices=0;
		s=new Stack<Integer>();
	}
	
	public void addVertex(char value)
	{
		Vertices[nVertices++]=new Vertex(value);
		
	}
	
	public void addEdge(int start, int end)
	{
		adjMatrix[start][end]=1;
	}
	
	
	public void display(int a)
	{
		System.out.print(Vertices[a].label+"\t");
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
	
	public void dfs()
	{
		Vertices[0].wasVisited=true;
		display(0);
		s.push(0);
		
		while(!s.isEmpty())
		{
			int valuee=getNeighbour(s.peek());
			
			if(valuee==-1)
			{
				s.pop();
			}
			else
			{
				Vertices[valuee].wasVisited=true;
				display(valuee);
				s.push(valuee);
			}
		}
		
		
	}
    
    
    public static void main(String[] args) {
        
        DirectedGraph thegraph=new DirectedGraph();
		thegraph.addVertex('P');
		thegraph.addVertex('U');
		thegraph.addVertex('K');
		thegraph.addVertex('A');
		
		thegraph.addEdge(0,1);
		thegraph.addEdge(0,3);
		thegraph.addEdge(1,2);
		
		
		System.out.print("Directed Graph created : ");
		thegraph.dfs();
    }
    
}
