public class KthBitSet {
    public static void main(String args[]){
        int mask = 1;
        int num = 24;
        // checking 3rd bit is set or not in num
        int numCheck =  (mask<<2) & num ;
        int numCheckActualNum = (mask<<3) & num;
        System.out.println(numCheck); // 1000 - prints 0 as mask 2 = 100, num = 11000
        System.out.println(numCheckActualNum); // - prints 8 // mask<<3 (1000) &  nums (11000) = 01000 =8


    }
}
