package graph;

public class NumberOfIsland {

    public static void main(String args[]) {
        int graph[][] = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        System.out.println("Number of Islands : "+ numberOfIsland.numIslands(graph));
    }

    public int numIslands(int graph[][]){
        int numIsland = 0;
        for(int i=0; i<graph.length;i++){
            for(int j =0; j<graph[i].length; j++){
                if(graph[i][j]==1){
                    markIslandDFS(graph, i, j);
                    numIsland++;
                }
            }
        }

        return numIsland;
    }


    private void markIslandDFS(int[][] graph, int i, int j){
        if(i<0 || i> graph.length-1 || j<0 || j> graph[i].length-1 || graph[i][j] ==0)
            return;
        graph[i][j]=0;
        markIslandDFS(graph,i++,j);
        markIslandDFS(graph,i--,j);
        markIslandDFS(graph,i,j++);
        markIslandDFS(graph,i,j--);
    }
}
