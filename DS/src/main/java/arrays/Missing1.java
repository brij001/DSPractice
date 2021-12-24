package arrays;

//https://www.geeksforgeeks.org/find-the-missing-number/
public class Missing1 {

    public static void main(String ...s ){

        int a[] = {1,2,3,4,5,6,7};
        System.out.println(findMissingMethod2(a));
    }

    public static int findMissing(int a[]){
        int n = a.length;
        int tot = 1;
        for(int i=2; i<=n+1 ; i++){
            tot = tot+i;
            tot = tot - a[i-2];
        }
        return tot;
    }

    // For sorted array we can use binary sort, reducing complexity to log(N) from O(n)
    public static int findMissingMethod2(int a[]){
        int n = a.length;
        int i = 0;
        int j = n-1;

        while(i<j){
            int mid = (i+j)/2 ;
            if(a[mid]-mid == 1  && a[mid+1]-(mid+1) == 2)
                return a[mid]+1;
            else if(mid==0)
                return a[mid]-1;
            else if(a[mid]-mid == 1)
                i = mid+1;
            else if(a[mid]-mid == 2)
                j = mid;
        }
        return n+1;
    }
}
