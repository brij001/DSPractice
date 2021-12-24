package graph;


import java.util.*;
import java.lang.*;

// https://www.youtube.com/watch?v=Ub-fJ-KoBQM&t=307s
class KrushkalsAlgoImpl {

    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edgeArr[]; // collection of all edges

    // Creates a graph with V vertices and E edges in advance
    KrushkalsAlgoImpl(int v, int e) {
        V = v;
        E = e;
        edgeArr = new Edge[E];
        for (int i = 0; i < e; ++i)
            edgeArr[i] = new Edge();
    }

    // A utility function to find set of an
    // element i (uses path compression technique)
    int findParnt(Subset subsets[], int i) {
        if (subsets[i].parent == -1)
            return i;
        // find root and make root as parent of i
        // (path compression)
        return subsets[i].parent = findParnt(subsets, subsets[i].parent);
    }

    // A function that does union of two sets of x and y (uses union by rank)
    void Union(Subset subsets[], int x, int y) {
        int xroot = findParnt(subsets, x);
        int yroot = findParnt(subsets, y);

        // Attach smaller rank tree under root of high rank tree (Union by Rank)
        if (subsets[xroot].rank
                < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's
    // algorithm
    void KruskalMST() {
        // Tnis will store the resultant MST
        Edge result[] = new Edge[V];

        int e = 0;

        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edgeArr);

        // Allocate memory for creating V ssubsets
        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = -1;
            subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = edgeArr[i];
            i++;

            int xAbsParent = findParnt(subsets, next_edge.src);
            int yAbsParent = findParnt(subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (xAbsParent != yAbsParent) {
                result[e++] = next_edge;
                Union(subsets, next_edge.src, next_edge.dest);
            }
            // Else discard the edge
        }


        System.out.println("Following are the edges in "
                + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- "
                    + result[i].dest
                    + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);
    }

    // Driver Code
    public static void main(String[] args) {

		/* Let us create following weighted graph
				10
			0--------1
			| \	 |
		6| 5\ |15
			|	 \ |
			2--------3
				4	 */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        KrushkalsAlgoImpl graph = new KrushkalsAlgoImpl(V, E);

        // add edge 0-1
        graph.edgeArr[0].src = 0;
        graph.edgeArr[0].dest = 1;
        graph.edgeArr[0].weight = 10;

        // add edge 0-2
        graph.edgeArr[1].src = 0;
        graph.edgeArr[1].dest = 2;
        graph.edgeArr[1].weight = 6;

        // add edge 0-3
        graph.edgeArr[2].src = 0;
        graph.edgeArr[2].dest = 3;
        graph.edgeArr[2].weight = 5;

        // add edge 1-3
        graph.edgeArr[3].src = 1;
        graph.edgeArr[3].dest = 3;
        graph.edgeArr[3].weight = 15;

        // add edge 2-3
        graph.edgeArr[4].src = 2;
        graph.edgeArr[4].dest = 3;
        graph.edgeArr[4].weight = 4;

        // Function call
        graph.KruskalMST();
    }




    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }
}
// This code is contributed by Aakash Hasija
