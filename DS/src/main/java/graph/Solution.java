package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
 // 0 -> 1
// 1 -> 0

    public static void main(String[] args) {
        int[][] pre = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}

        };
        Solution solution = new Solution();
        System.out.println(solution.canFinish(4, pre));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i=0; i<prerequisites.length; i++) {
            adjMap.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            adjMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean visited[] = new boolean[numCourses];


        for(Map.Entry<Integer, List<Integer>> entry: adjMap.entrySet()){
            Integer src = entry.getKey();
            boolean dfsVisited[] = new boolean[numCourses];

            if(!visited[src] && isCycle(src, visited, dfsVisited)){
                System.out.println("Cycle");
                return false;
            }


        }

        return true;

    }

    private Boolean isCycle(Integer src, boolean visited[], boolean dfsVisited[]){
        visited[src] = true;
        dfsVisited[src]= true;
        List<Integer> list = adjMap.get(src);

        if(list!=null)
        for(Integer i : list){
            if(!visited[i]){
                if(isCycle(i,visited,dfsVisited)==true)
                    return true;
            } else if(dfsVisited[i]==true)
                return true;

        }

        dfsVisited[src] = false;

        return false;
    }

    private Boolean isCycleUsingColorCoding(Integer src, int[] visited){ // default value in visited[] will be 0
        if(visited[src]==1) // 1 = processing
            return true;

        visited[src] = 1;
        for(Integer child : adjMap.get(src)){
            if(visited[child]!=2) { // 2 = processed
                boolean isCycle = isCycleUsingColorCoding(child, visited);
                if(isCycle)
                    return true;
            }
        }

        visited[src] = 2;
        return false;
    }

}