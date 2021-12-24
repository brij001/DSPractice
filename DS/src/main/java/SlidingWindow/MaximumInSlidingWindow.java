package SlidingWindow;

import java.util.*;

// https://www.youtube.com/watch?v=TCHSXAu5pls
public class MaximumInSlidingWindow {

    public static void main(String ...s){

        int a[] = {3,5,26,75,16,7,3,7,8,4,26,6};
        //int a[] = {4,1,3,2,6};
        int k = 3;
        /**
         * Check for the value of K = 0
         * Check for the value of K when K> a.length
         * check for blank array
         * Check very large value of a
         * Check for very large value of K
         * Strictly increasing values & strictly decreasing values
         * First increasing and then decreasing
         * a.length = k
         */

        List<Integer> list= findMax3(a,k);
        for(Integer result : list){
            System.out.print(result+ ",");
        }

        System.out.println();

        int aa[]=  maxSlidingWindow(a,2);
        for(int i=0; i<aa.length ; i++){
            System.out.print(aa[i]+ ",");
        }


    }




    public int[] findMaxBruteForce(int a[], int k){
        int maxValArr[] = new int[14];
        int maxElt = Integer.MIN_VALUE;
        int count = 0;

        for(int j=0;j<a.length;j++){
            maxElt = Integer.MIN_VALUE;
            for(int i=j; i<k && i<a.length; i++){
                if(maxElt<a[i]){
                    maxElt = a[i];
                }
            }
            maxValArr[count++] = maxElt;
        }
        return maxValArr;
    }


    public static List<Integer> findMax3(int arr[], int k){
        List<Integer> ans = new ArrayList<Integer>();
        LinkedList<Integer> max = new LinkedList<Integer>();

        for(int i = 0 ; i < arr.length ; i++){
            if(!max.isEmpty() && i-k == max.peek()){
                max.poll();
            }

            if((!max.isEmpty()) && arr[i]  <= arr[max.peekLast()]){
                max.addLast(i);
            }else{
                while( !max.isEmpty() && arr[i] > arr[max.peekLast()]  ){
                    max.removeLast();

                }

                max.addLast(i);
            }

            // This is because we haven't handled first window separately like in findMax2
            // findMax2 didn't handle {4,1,3,2,6};
            if(i >= k-1)
                ans.add(arr[max.peek()]);
        }

        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] maxElts = new int[nums.length-k+1];
        int i=0;
        int m =0;
        Deque<Integer> queue = new LinkedList<Integer>();
        while(i<k){
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            i++;
        }
        maxElts[m] = nums[queue.getFirst()];
        m++;
        for(; i<nums.length;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);

            if(queue.peekFirst() == i-k)
                queue.removeFirst();

            maxElts[m++] = nums[queue.peekFirst()];
        }

        return maxElts;
    }
}

