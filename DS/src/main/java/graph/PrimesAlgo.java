package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//   https://www.youtube.com/watch?v=xthRL0lcx2w
public class PrimesAlgo {
    public static void main(String args[]){
        int graph[][] = new int[][]{
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };

        PrimesAlgo primesAlgo = new PrimesAlgo();
        primesAlgo.minSpanningTree(graph);
    }

    public void minSpanningTree(int graph[][]){
        int vertices = graph.length;
        int parent[] = new int[vertices];
        int weightAtVertecies[] = new int[vertices];
        Arrays.fill(weightAtVertecies, Integer.MAX_VALUE);
        weightAtVertecies[0] = 0;
        parent[0] = -1;
        Set<Integer> mstSet = new HashSet<Integer>();

        // edges = vertices-1
        for(int i=0; i<vertices-1; i++){
            int v = getMinFromChildsNotInMSTSet(weightAtVertecies,mstSet);
            mstSet.add(v);

            for(int u=0; u<vertices; u++){
                int edgeWeight = graph[v][u];
                Boolean inMstSet = mstSet.contains(u);
                if(edgeWeight!=0 && !inMstSet && edgeWeight<weightAtVertecies[u]){
                    weightAtVertecies[u] = edgeWeight;
                    parent[u] = v;
                }
            }
        }
        printMST(parent,graph);
    }

    private int getMinFromChildsNotInMSTSet(int weightAtVertices[] , Set<Integer> mstSet) {

        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for(int i=0; i<weightAtVertices.length; i++){
            if(!mstSet.contains(i) && min > weightAtVertices[i]){
                min = weightAtVertices[i];
                min_index = i;
            }
        }
        return min_index;
    }


    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

}
