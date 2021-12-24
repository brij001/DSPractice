package graph;

import java.util.*;

public class TopologicalSort {


    public void sortUsingTopologicalSort( Map<Integer,List<Integer>> adjacencyMap, Stack<Integer> stck, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> childNodesOfCurrent = adjacencyMap.get(node);
        for (int i = 0; childNodesOfCurrent!=null && i < childNodesOfCurrent.size(); i++) {
                if(!visited[childNodesOfCurrent.get(i)])
                sortUsingTopologicalSort(adjacencyMap, stck, visited, childNodesOfCurrent.get(i));
        }
        stck.push(node);

    }

    public static void main(String args[]) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        TopologicalSort topologicalSort = new TopologicalSort();
        Stack<Integer> sortedStack = new Stack<Integer>();
        boolean visted[] = new boolean[graph.getNumberOfVertices()];
        Arrays.fill(visted,false);

       for(Map.Entry<Integer,List<Integer>> entry : graph.getAdjacencyMapForAllNodes().entrySet()){
        //for(int i=0; i< graph.vertices.length; i++){
            int srcNode = entry.getKey();
            if(!visted[srcNode])
             topologicalSort.sortUsingTopologicalSort(graph.getAdjacencyMapForAllNodes(), sortedStack, visted, srcNode);
        }
        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }


    }



    public int[] topoSortUsingBFS(int N, ArrayList<ArrayList<Integer>> adj) { // Kahn's algorith
        int topo[] = new int[N];
        int indegree[] = new int[N];
        for(int i = 0;i<N;i++) {
            for(Integer it: adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        // add all nodes with 0 indegree
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll();
            topo[cnt++] = node;
            for(Integer it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
     return topo;
    }

    public static class Graph {
        int[] vertices;
        Map<Integer,List<Integer>> adjacencyMap;

        public Graph(int numOfVertices) {
            vertices = new int[numOfVertices];
            adjacencyMap = new HashMap<>();
        }

        public void addEdge(int srcVertex, int destVertex) {
            vertices[srcVertex] = srcVertex;
            vertices[destVertex] = destVertex;
            List<Integer> list = adjacencyMap.getOrDefault(srcVertex,new ArrayList<>());
            list.add(destVertex);
            adjacencyMap.put(srcVertex, list);
        }

        public Map<Integer, List<Integer>> getAdjacencyMapForAllNodes() {
            return adjacencyMap;
        }

        public int getNumberOfVertices() {
            return vertices.length;
        }

    }


}
