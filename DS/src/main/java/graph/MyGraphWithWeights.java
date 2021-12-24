package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyGraphWithWeights {
	private int noOfVertex;

	private List<Edge> adjacencyList[] = null;


	class Edge{
		Character v;
		int w;

		public Edge(Character v, int w){
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString(){
			return "["+ v + " - "+w + "]";
		}
	}

	public MyGraphWithWeights(int noOfVertex){
		this.noOfVertex = noOfVertex;
		this.adjacencyList = new LinkedList[noOfVertex];
		for(int i=0; i<noOfVertex; i++)
			adjacencyList[i] = new LinkedList<Edge>();
	}


	public void addEdge(int index, Character dest, int w){
		Edge e = new Edge(dest, w);
		adjacencyList[index].add(e);
	}

	public void printGraph(){
		for(int i=0; i<noOfVertex; i++){
			System.out.println( " Adjacency List for Vertex : "+ i);
			for(Edge c : adjacencyList[i]){
				System.out.print(c.toString() + " ");
			}
			System.out.println();

		}
	}

	public static void main(String ...strings){
		MyGraphWithWeights g = new MyGraphWithWeights(5);
		
		g.addEdge( 0, 'D', 5);
		g.addEdge( 0, 'B', 4);
		g.addEdge( 0, 'C', 3);
		g.addEdge( 0, 'E', 2);
		g.addEdge( 1, 'C', 1); 

		g.printGraph();

	}

	
	public void bfs(int startNode){
		
		int visited[] = new int[noOfVertex];
		List<Edge> queue = new LinkedList<Edge>();
		
	
		
		
	}
	
	
	
	
}
