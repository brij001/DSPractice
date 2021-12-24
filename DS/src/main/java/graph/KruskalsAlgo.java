package graph;

// https://www.youtube.com/watch?v=Ub-fJ-KoBQM&t=307s
public class KruskalsAlgo {

    // Step 1 - Sort edges by weight
    // Now find if the edge can be chosen for MST
    // Step 2 - Find Absolute parent of V1, V2 (this will help deciding if the edge V1 -> V2 can be considered)
    // Step 3 - Union
    // if Abs. parent V1 == Abs. parent V2 ; it will make cycle, so ignore this edge ( V1 -> V2) end continue
    // if Abs. parent V1. rank < Abs. parent V2. rank =>  V1[parent]= V2
    // else if Abs. parent V1. rank > Abs. parent V2. rank => V2[parent] = V1
    // else when rank of both is equal make any parent of another say V2[parent] = V1; V1.rank++;
    // add the edge to your resultant
}
