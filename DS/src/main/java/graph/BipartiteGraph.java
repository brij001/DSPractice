package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public static void main(String[] args) {
        int[][] graph = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };
        BipartiteGraph b = new BipartiteGraph();
        System.out.println(b.isBipartite(graph));
    }
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);

        for(int i=0; i<graph.length; i++){
            if(color[i]==-1){
                if(!bipartiteBFSHelper(graph, color, i))
                    return false;
            }
        }
        /**
         If using DFS
             for(int i=0; i<graph.length; i++){
                 if(color[i]==-1){
                     color[i]=0;
                     if(!bipartiteDFSHelper(graph, color, i))
                        return false;
                 }
             }
         */
        return true;
    }

    private boolean bipartiteBFSHelper(int [][]graph, int color[], int i) {
        if(color[i]==-1)
            color[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int parent = q.poll();
            int []children = graph[parent];
            for(Integer child : children){
                if(color[child]==-1){
                    color[child] = 1- color[parent];
                    q.add(child);
                } else if(color[child]==color[parent])
                    return false;
            }
        }
        return true;
    }

    private boolean bipartiteDFSHelper(int [][]graph, int color[], int i) {

        int[] children = graph[i];
        for(int child : children){
            if(color[child]==-1) {
                color[child] = 1 - color[i];
                if(bipartiteDFSHelper(graph, color, child)==false){
                    return false;
                }
            }
            else if(color[child]==color[i])
                return false;

        }
        return true;
    }
}