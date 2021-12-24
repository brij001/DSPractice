package recur;

public class ReverseString {

    public static void main(String ...s)    {
        ReverseString r = new ReverseString();
        String h = "HiiiiiHale";

        revString(h,0);
       System.out.println(reverseString("HiiiiiHale") );
    }


    public static void revString(String s, int i ){
        if( i == s.length())
            return ;
        i++;
        revString(s,i);
        System.out.print(s.charAt(i-1));
    }


    public static String reverseString(String str)
    {
        if (str==null || str.length() <= 1) {
            return str;
        }
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}



