package recur;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String ...s){
        int[] nums = {1,2,3};
        Subsets ss = new Subsets();
        List<List<Integer>> subsets = ss.subsets(nums);
        for(List<Integer> intList : subsets){
            for(Integer intVal : intList){
                System.out.print(intVal + ",");
            }
            System.out.println("");
        }

    }

    public List<List<Integer>> subsets(int num[]) {
        List<List<Integer>> subsetList = new ArrayList<List<Integer>>();
        subsetList.add(new ArrayList<Integer>());

        for(int i=0;i<num.length;i++){
            int subsetListSize = subsetList.size();
            for(int j=0;j<subsetListSize;j++){
                List<Integer> listElt = subsetList.get(j);
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(listElt);
                temp.add(num[i]);
                subsetList.add(temp);
            }
        }

        return subsetList;

    }


}
