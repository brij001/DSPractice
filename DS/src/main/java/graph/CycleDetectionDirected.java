package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetectionDirected {


    public static void main(String args[]) {
        CycleDetectionDirected cycleDetectionDirected = new CycleDetectionDirected();
        Graph graph = new CycleDetectionDirected.Graph(5);
       /** graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 0);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2); */

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);

        boolean cycle = cycleDetectionDirected.containsCycle(graph.getMapAdjacency(), graph.numOfVertices);
        System.out.println("Contains Cycle in Directed Graph : " + cycle);
        boolean cycleUsingColorCoding = cycleDetectionDirected.containsCycleUsingGraphColoring(graph.getMapAdjacency(), graph.numOfVertices);
        System.out.println("Contains Cycle in Directed Graph Color Coding : " + cycleUsingColorCoding);

    }

    public boolean containsCycle(Map<Integer, List<Integer>> mapAdjacency, int numOfVertices) {
        boolean visited[] = new boolean[numOfVertices];
        for (Map.Entry<Integer, List<Integer>> entry : mapAdjacency.entrySet()) {
            int src = entry.getKey();
            boolean dfsvisited[] = new boolean[numOfVertices];
            if(!visited[src]) {
                boolean isCycle = containsCycleUtil(mapAdjacency, src, dfsvisited, visited);
                if (isCycle) {
                    System.out.println("Cycle");
                    return true;
                }
            }
        }
        return false;
    }


    private boolean containsCycleUtil(Map<Integer, List<Integer>> mapAdjacency, int currentNode, boolean dfsVisited[], boolean visited[]) {

        dfsVisited[currentNode] = true;
        visited[currentNode] = true;
        List<Integer> childNodes = mapAdjacency.get(currentNode);
        for (int i = 0; childNodes != null && i < childNodes.size(); i++) {
            if(!visited[childNodes.get(i)]){
                     boolean containsCycle = containsCycleUtil(mapAdjacency, childNodes.get(i), dfsVisited, visited);
                     if (containsCycle)
                        return true;
            } else if(dfsVisited[childNodes.get(i)])
                return true;
        }
        dfsVisited[currentNode] = false;
        return false;
    }


    public boolean containsCycleUsingGraphColoring(Map<Integer, List<Integer>> mapAdjacency, int numOfVertices) {
        int visited[] = new int[numOfVertices];
        for (Map.Entry<Integer, List<Integer>> entry : mapAdjacency.entrySet()) {
            int src = entry.getKey();
            if(visited[src]==0) {
                boolean isCycle = isCycleUsingColorCoding(mapAdjacency, src, visited);
                if (isCycle) {
                    System.out.println("Cycle");
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isCycleUsingColorCoding(Map<Integer, List<Integer>> mapAdjacency, Integer src, int[] visited){ // default value in visited[] will be 0
        if(visited[src]==1) // 1 = processing
            return true;

        visited[src] = 1;
        List<Integer> list = mapAdjacency.get(src);
        if(list!=null)
        for(Integer child : list){
            if(visited[child]!=2) { // 2 = processed
                boolean isCycle = isCycleUsingColorCoding(mapAdjacency, child, visited);
                if(isCycle)
                    return true;
            }
        }

        visited[src] = 2;
        return false;
    }


    public static class Graph {
        int numOfVertices;
        Map<Integer, List<Integer>> mapAdjacency;

        public Graph(int numOfVertices) {
            this.numOfVertices = numOfVertices;
            mapAdjacency = new HashMap<>();
        }

        public void addEdge(int src, int dest) {
            List<Integer> edgesFromSrc = mapAdjacency.getOrDefault(src, new ArrayList<Integer>());
            edgesFromSrc.add(dest);
            mapAdjacency.put(src, edgesFromSrc);
        }

        public Map<Integer, List<Integer>> getMapAdjacency() {
            return mapAdjacency;
        }
    }


}
