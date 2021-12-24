package graph;

import java.util.LinkedList;
import java.util.List;

public class DFS {

    private LinkedList<Integer>[] adjacencyList;
    int vertices;

    DFS(int numOfVertices){
        this.vertices = numOfVertices;
        adjacencyList = new LinkedList[vertices];
        for(int i=0; i<vertices; i++){
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int src, int to){
        adjacencyList[src].add(to);
    }


    public static void main(String args[]){
        DFS bfs = new DFS(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        bfs.dfsMethod(2);
    }


    public void dfsMethod(int startingNode){
        boolean[] visited = new boolean[vertices];
        printDFS(startingNode, visited);
    }
    public void printDFS(int startingNode, boolean[] visited){

        System.out.println(" "+startingNode);
        visited[startingNode] = true;

        List<Integer> list = adjacencyList[startingNode];
        for(int i=0; i< list.size(); i++){
            if(!visited[list.get(i)]){
                printDFS(list.get(i),visited);
            }
        }
    }


}
