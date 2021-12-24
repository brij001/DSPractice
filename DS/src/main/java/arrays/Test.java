package arrays;

public class Test {

    public static void main(String args[]){

        int arr[] = {2,2,2,3,3,4,5,6,6,6,7} ;
       //printArr(arr);
        int nums[]= {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static  void printArr(int arr[]){

        System.out.println(arr[0]);

        if(arr.length==1){
           return;
        }

        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]){
                System.out.println(arr[i]);
            }
        }
    }

    public static int removeDuplicates(int[] nums) {

        int j=0;
        for(int i=1; i<nums.length; i++){
            if(nums[j]!=nums[i]){
                j++;
                nums[j]=nums[i];
            }
        }
        if(nums.length==1)
            return 1;
        return j+1;
    }

}
