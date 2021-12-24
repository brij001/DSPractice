package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleDetectionUndirectedGraph {
    boolean visted[];
    Edge edgeArr[] ;
    int[] vertices = {0, 1, 2, 3, 4, 5,};
    List<Integer> adjacencyList[];

    public CycleDetectionUndirectedGraph(){
        initEdges();
        initAdjacencyList();

    }
    private boolean findCycleDFSUtil(int parent, int curr, int[] visited) {

        visited[curr] = 1;
        List<Integer> currList = adjacencyList[curr];
        for (int i = 0; i < currList.size(); i++) {

            if(visited[currList.get(i)]==0){
                // 1, 6
                 if(findCycleDFSUtil(curr, currList.get(i), visited))
                     return true;
            } // because in adjacencyList numbers are repeated for ex. adjacencyList[1] -> 6 then it will also have adjacencyList[1] -> 6
            else if(visited[currList.get(i)]==1 && currList.get(i) != parent){
                return true;
            }
        }


        return false;
    }

    public void findCycleDFS() {
        int[] visited = new int[vertices.length];
        Arrays.fill(visited,0);
        int parent = -1;

        for(int u=0; u<adjacencyList.length; u++){
            if(visited[u]==0){
                boolean isCycle = findCycleDFSUtil(parent, u, visited);
                if(isCycle){
                    System.out.println("Cycle is present ");
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        CycleDetectionUndirectedGraph cycleDetection = new CycleDetectionUndirectedGraph();

        // Uses adjacencyList
        cycleDetection.findCycleDFS();
        // Uses edges
        System.out.println(cycleDetection.isCycleUsingDisjointSet(cycleDetection.edgeArr));
    }



    public boolean isCycleUsingDisjointSet(Edge[] edgeArr){
        int[] parent = new int[vertices.length];
        Arrays.fill(parent,-1);
        int[] rank = new int[vertices.length];
        Arrays.fill(rank,0);


        for (int i=0; i< edgeArr.length;i++){
            int xParent = findAbsParent(edgeArr[i].from, parent);
            int yParent = findAbsParent(edgeArr[i].to, parent);
            if(xParent==yParent){
                return true;
            }
            UnionSet(xParent,yParent, parent, rank);
        }
        return false;
    }


    private int findAbsParent(int vertex, int parent[]){
        if(parent[vertex]==-1)
            return vertex;
        return findAbsParent(parent[vertex], parent);
    }

    private void UnionSet(int xParent, int yParent, int[] parent, int[] rank){

        if(rank[xParent]> rank[yParent])
            parent[yParent] = xParent;
        else if (rank[xParent] < rank[yParent])
            parent[xParent] = yParent;
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }

    }


    private static class Edge {

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        int from;
        int to;
    }


    public void initAdjacencyList(){
        adjacencyList = new ArrayList[vertices.length];
        List<Integer> list0 = new ArrayList<Integer>();
        list0.add(1);
        list0.add(2); // 0 -> 1,2
        adjacencyList[0] = list0;

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(0); // 1 -> 0
        adjacencyList[1] = list1;

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0);
        list2.add(3);
        list2.add(5); // 2 -> 0,3,5
        adjacencyList[2] = list2;

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(2);
        list3.add(4); // 3 -> 2,4
        adjacencyList[3] = list3;

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(5);
        list4.add(3); // 4 -> 5,3
        adjacencyList[4] = list4;

        List<Integer> list5 = new ArrayList<Integer>();
        list5.add(2);
        list5.add(4); // 5 -> 2,4
        adjacencyList[5] = list5;
    }

    private void initEdges(){
        edgeArr = new Edge[6];

        Edge edge1 = new Edge(0, 1);
        Edge edge2 = new Edge(0, 2);
        Edge edge3 = new Edge(2, 3);
        Edge edge4 = new Edge(3, 4);
        Edge edge5 = new Edge(4, 5);
        Edge edge6 = new Edge(5, 2);
        int i =0;
        edgeArr[i++] = edge1;
        edgeArr[i++] = edge2;
        edgeArr[i++] = edge3;
        edgeArr[i++] = edge4;
        edgeArr[i++] = edge5;
        edgeArr[i++] = edge6;
    }
}
