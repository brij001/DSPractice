package dp;

import java.util.ArrayList;
import java.util.Arrays;

class SumOfDistancesInTree {

    public static void main(String[] args) {
        int n =6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        SumOfDistancesInTree sol = new SumOfDistancesInTree();
        sol.sumOfDistancesInTree(n, edges);
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        //create the adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        int[] counts = new int[n];
        Arrays.fill(counts, 0);

        int[] distanceSums = new int[n];

        //conside 0 as root,
        //but u can consider any root 0 to n - 1

        //distanceSums[node] = distance sum of child node
        postOrder(graph, 0, -1, counts, distanceSums);

        //distance sum of from other node
        preOrder(graph, 0, -1, counts, distanceSums);

        return distanceSums;
    }


    private void postOrder(ArrayList<Integer>[] graph, int currNode, int parentNode, int[] counts, int[] distanceSums){
            for(int childNode : graph[currNode]){
            //ignore it parennt node to
            if(childNode == parentNode) continue;


            //first handle current child
            postOrder(graph, childNode, currNode, counts, distanceSums);


            //append the child counts to the currentNode
            counts[currNode] += counts[childNode];

            //update the distance of subtree of child node
            distanceSums[currNode] += (distanceSums[childNode] + counts[childNode]);

            if(counts[currNode]!=distanceSums[currNode])
                System.out.println(counts[currNode] + " - " + distanceSums[currNode]);

        }
        counts[currNode]++;
    }


    private void preOrder(ArrayList<Integer>[] graph, int currNode, int parentNode, int[] counts, int[] distanceSums){
        for(int childNode : graph[currNode]){
            //ignore it parennt node to
            if(childNode == parentNode) continue;

            //sums[x] - sums[y] = #(Y) - #(X).
            distanceSums[childNode] = distanceSums[currNode] + (graph.length - 2 * counts[childNode]);


            preOrder(graph, childNode, currNode, counts, distanceSums);
        }
    }
}