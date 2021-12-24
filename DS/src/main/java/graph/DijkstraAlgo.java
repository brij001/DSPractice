package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Time Complexity Analysis of Priority Queue
// as we are inserting the element only once to Priority queue despite of two loops so  vlogv + E logv
public class DijkstraAlgo {

    public static void main(String args[]){
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        DijkstraAlgo dijkstraAlgo = new DijkstraAlgo();
        dijkstraAlgo.shortPathAlgo(graph);

    }

    private int getMinFromChildsNotInMSTSet(int weightAtVertices[] , Set<Integer> mstSet) {

        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i=0; i<weightAtVertices.length; i++){
            if(!mstSet.contains(i) && min >= weightAtVertices[i]){
                min = weightAtVertices[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public void shortPathAlgo(int graph[][]){
        int vertices = graph.length;
        int weightAtVertecies[] = new int[vertices];
        Arrays.fill(weightAtVertecies, Integer.MAX_VALUE);
        weightAtVertecies[0] = 0;
        int parent[] = new int[vertices];
        parent[0] = -1;

        Set<Integer> mstSet = new HashSet<Integer>();

        // edges = vertices-1
        for(int i=0; i<vertices-1; i++){
            int v = getMinFromChildsNotInMSTSet(weightAtVertecies,mstSet);
            mstSet.add(v);

            for(int u=0; u<vertices; u++){
                int edgeWeight = graph[v][u];
                Boolean inMstSet = mstSet.contains(u);
                if(edgeWeight!=0 && !inMstSet && edgeWeight+weightAtVertecies[v]<weightAtVertecies[u] && weightAtVertecies[v]!=Integer.MAX_VALUE){
                    weightAtVertecies[u] = edgeWeight + weightAtVertecies[v];
                    parent[u] = v;
                }
            }
        }
        printMST(parent, graph);
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[parent[i]][i]);
    }

}
