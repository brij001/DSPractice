package arrays;

import java.util.*;

public class FindTripletsSumZero {


    public static void main(String args[]) {

        int arr[] = {-1,0,1,2,-1,-4} ;//{0, -1, 2, -3, 1};

        FindTripletsSumZero f = new FindTripletsSumZero();
        //f.printTriplet(arr);

        List<List<Integer>> list = threeSum(arr);
        System.out.println(list.size());
    }

    public void printTriplet(int a[]){

        for(int i=0;i<a.length-1;i++){

            Set<Integer> jIntegers = new HashSet<Integer>();

            for(int j=i+1; j<a.length;j++){

                int x = -1 * (a[i]+a[j]);

                if(jIntegers.contains(x)){
                    System.out.println(a[i] + " , " + a[j] +  " , " + x);
                } else{
                    jIntegers.add(a[j]);
                }
            }
        }
    }

    public List<List<Integer>> threeSumWithoutDuplicates(int[] nums) {
        List<List<Integer>> zeroSumTriplets= new LinkedList();
        Arrays.sort(nums);

        // -4, -1, -1, 0, 1, 2
        for(int i=0; i<nums.length-2; i++){
            int low = i+1;
            int high = nums.length-1;

            if(i!=0 && nums[i]==nums[i-1]) continue;
            // skip same element

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

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplet = new ArrayList<List<Integer>>();

        for(int i=0; i<nums.length-1; i++){
            List<Integer> tempList = new ArrayList<Integer>();
            for(int j=i+1; j<nums.length; j++){
                int rem = -1 * (nums[i]+ nums[j]);
                if(tempList.contains(rem)){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i])  ;
                    list.add(nums[j]);
                    list.add(rem);
                    triplet.add(list);
                } else{
                    tempList.add(j);
                }
            }
        }
        return triplet;
    }
}
