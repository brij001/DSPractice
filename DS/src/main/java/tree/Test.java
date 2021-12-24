package tree;

public class Test {
    public static void main(String[] args) {
        int a[] = new int[6];
        init(a,0,0);
        for(int i=0; i<6 ; i++)
            System.out.println(a[i]);
    }

    private static void init(int a[], int i, int j){
        if(j>=4)
            return;

        a[i] = i;
        init(a,i+1, ++j);
    }
}
