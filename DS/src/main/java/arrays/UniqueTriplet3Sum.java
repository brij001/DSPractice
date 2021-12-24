package arrays;

import java.util.*;

public class UniqueTriplet3Sum {
    public static void main(String...s){
        //int nums1[] ={4,9,5,5,6,9};
        int nums2[] = {-1,0,1,2,-1,-4};
        threeSum(nums2);

    }

    public static List<List<Integer>> threeSumUsingSets(int[] nums) {
        List<Integer> triples = null;
        HashSet<Integer> set = null;
        HashSet<List<Integer>> tripleSet = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            set = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                int x = -(nums[i] + nums[j]);
                if (set.contains(x)) {
                    Integer [] temp = {x,nums[i],nums[j]};
                    Arrays.sort(temp);
                    triples = new ArrayList<Integer>();
                    triples.add(temp[0]);
                    triples.add(temp[1]);
                    triples.add(temp[2]);
                    tripleSet.add(triples);
                } else {
                    set.add(nums[j]);
                }

            }
        }
        return new ArrayList<List<Integer>>(tripleSet);
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        //List<List<Integer>> zeroSumTriplets= new ArrayList<List<Integer>>();
        List<List<Integer>> zeroSumTriplets= new LinkedList<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            int low = i+1;
            int high = nums.length-1;

            // skip same element
            if(i!=0 && nums[i]==nums[i-1]) continue;


            while(low<high){

                if( nums[low] + nums[high] + nums[i]==0){
                    List<Integer> triples = new ArrayList<Integer>();
                    triples.add(nums[i]);
                    triples.add(nums[low]);
                    triples.add(nums[high]);
                    zeroSumTriplets.add(triples);
                    while(high>low && nums[high]==nums[high-1])
                        high--;
                    while(high>low && nums[low]==nums[low+1])
                        low++;
                    high--;
                    low++;
                } else if(nums[low] + nums[high] + nums[i]>0 ) {
                    high--;
                } else {
                    low++;
                }

            }
        }

        return zeroSumTriplets;
    }
}
