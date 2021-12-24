package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyGraph {
	private int noOfVertex;

	private List<Character> adjacencyList[] = null;

	@SuppressWarnings("unchecked")
	public MyGraph(int noOfVertex){
		this.noOfVertex = noOfVertex;
		this.adjacencyList = new LinkedList[noOfVertex];
		for(int i=0; i<noOfVertex; i++)
			adjacencyList[i] = new LinkedList<Character>();
	}


	public void addEdge(MyGraph g, Character src, Character dest){
		for(int i=0; i<g.noOfVertex; i++){

			if(adjacencyList[i].isEmpty()){
				adjacencyList[i].add(src);
				adjacencyList[i].add(dest);
				break;
			} else if(adjacencyList[i].get(0) ==src ){
				adjacencyList[i].add(dest);
				break;
			}
		}
	}

	public void printGraph(){
		for(int i=0; i<noOfVertex; i++){
			System.out.println( " Adjacency List for Vertex : "+ adjacencyList[i].get(0) );
			for(Character c : adjacencyList[i]){
				System.out.print(adjacencyList[i].get(0) + " --> " + c + " : ");
			}
			System.out.println();

		}
	}

	
	public int getAdjacencyIndex(Character c){
		for(int i=0; i<noOfVertex; i++){
			if(adjacencyList[i].get(0)==c)
				return i;
		} return -1;
	}
	
	public static void main(String ...strings){
		MyGraph g = new MyGraph(5);
		g.addEdge(g, 'A', 'B');
		g.addEdge(g, 'A', 'C');
		g.addEdge(g, 'A', 'D');
		g.addEdge(g, 'A', 'E');

		g.addEdge(g, 'B', 'C');
		g.addEdge(g, 'C', 'C');
		g.addEdge(g, 'C', 'D');
		g.addEdge(g, 'D', 'D');
		g.addEdge(g, 'E', 'E');
		g.addEdge(g, 'D', 'E');
		g.printGraph();
		
		System.out.println("-------------------");
		g.bfs('B');

	}


	public void bfs(Character startNode){

		//Character visited[] = new Character[noOfVertex];
		List<Character> queue = new LinkedList<Character>();
		
		queue.add(startNode);
		List<Character> visited = new ArrayList<Character>();
		visited.add(startNode);
	
		
		while(!queue.isEmpty()){
			Character c = queue.remove(0);
			int i = getAdjacencyIndex(c);
			//System.out.println("ADJ : "+i);
			System.out.println( " "+ c);
			
			for(Character nextChars  :adjacencyList[i]){
				
				if(!visited.contains(nextChars)) {
					queue.add(nextChars);
					visited.add(nextChars);
				}
			}
			
		}




	}








}
