package graph;

import java.util.*;

public class ItineraryUsingTopologicalSort {

    // Another Important Itinerary - https://www.youtube.com/watch?v=WYqsg5dziaQ
    // Covers the cyclical Itinerary
    public static void main(String args[]){

        ItineraryUsingTopologicalSort itineraryUsingTopologicalSort = new ItineraryUsingTopologicalSort();

        Graph graph = new Graph();
        graph.addEdge("Chennai", "Banglore");
        graph.addEdge("Bombay", "Delhi");
        graph.addEdge("Goa", "Chennai");
        graph.addEdge("Delhi", "Goa");

        Map<String, List<String>> mapSrDest = graph.srcDestMap;
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        for(Map.Entry<String,List<String>> entry : mapSrDest.entrySet()){
            String src = entry.getKey();
            if(!visited.contains(src)){
                itineraryUsingTopologicalSort.
                        topologicalSort(mapSrDest, visited, src, stack);
            }
        }

        while (!stack.isEmpty())
            System.out.println(stack.pop());

    }

    public void topologicalSort(Map<String,List<String>> mapSrcDest, Set<String> visited, String currentNode, Stack<String> stack){
       visited.add(currentNode);
       List<String> childNodes = mapSrcDest.get(currentNode);
       for(int i=0; childNodes!=null && i<childNodes.size(); i++){
           if(!visited.contains(childNodes.get(i))){
               topologicalSort(mapSrcDest,visited, childNodes.get(i), stack);
           }
       }

       stack.push(currentNode);

    }




    public static class Graph {

        public Map<String, List<String>> srcDestMap ;

        Graph(){
            srcDestMap = new HashMap<>();
        }

        public void addEdge(String src, String dest){
            List<String> destList = srcDestMap.getOrDefault(src, new ArrayList<>());
            destList.add(dest);
            srcDestMap.put(src,destList);
        }
    }

}
