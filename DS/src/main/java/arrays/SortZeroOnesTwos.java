package arrays;

public class SortZeroOnesTwos {

    public static void main(String ...s){

        int a[] = {0,1,2,0,1,2};

        int l = 0, m = 0;
        int h = a.length-1;
        while(m<=h){

            if(a[m]== 0 ){
                swap(a,l,m);
                l++; m++;
            } else if(a[m] == 1){
                m++;
            } else if(a[m]==2){
                swap(a,m,h);
                h--;
            }

        }

        for(Integer val : a){
            System.out.println(val);
        }
    }

    public static void swap(int a[], int index1, int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
