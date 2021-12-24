package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    private LinkedList<Integer>[] adjacencyList;
    int vertices;

    BFS(int numOfVertices){
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
        BFS bfs = new BFS(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        bfs.printBFS(2);
    }


    public void printBFS(int startingNode){

        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[vertices];

        queue.add(startingNode);
        visited[startingNode] = true;

        while (!queue.isEmpty()){
            int visitingNode = queue.poll();
            System.out.println(" "+visitingNode);

            LinkedList<Integer> adjList = adjacencyList[visitingNode];
            for(int adjNode=0; adjNode < adjList.size(); adjNode++){
                if(!visited[adjList.get(adjNode)]) {
                    visited[adjList.get(adjNode)] = true;
                    queue.add(adjList.get(adjNode));
                }
            }
        }
    }




}
