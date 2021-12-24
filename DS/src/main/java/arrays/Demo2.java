package arrays;

import java.util.*;

public class Demo2 {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mapList = new HashMap<String, List<String>>();
        List<List<String>> ll = new ArrayList<List<String>>();

        for(int i=0; i<strs.length;i++){
            char s[] = strs[i].toCharArray();
            Arrays.sort(s);
            String sortedString = String.valueOf(s);
            if(mapList.containsKey(sortedString)){
                List<String> listVal = mapList.get(sortedString);
                listVal.add(strs[i]);
                mapList.put(sortedString,listVal);
            } else{
                List<String> listVal = new ArrayList<String>();
                listVal.add(strs[i]);
                mapList.put(sortedString,listVal);
            }
        }

        for(Map.Entry<String,List<String>> entry : mapList.entrySet()){
            ll.add(entry.getValue());
        }
        return ll;

    }

    public static void main(String args[]) {
        String Str = "Amazon_w_e_b_services are___widely__used_acc__ro___ss_the_worl_d";
        String Str2 = null;
        if (Str.contains("_")) {
            Str2 = Str.replaceAll("_", " ");
        }

        System.out.println("String is: " + Str2.toString());


    }

    public static void remove_space(String data) {
        String expected_string = "Amazon web services are widely used accross the world";
        String[] exp_str_list = expected_string.split(" ");
        String[] data_ary = data.split("_");
        String a = "";
        String new_string = "";

        for (int i = 0; i < data_ary.length; i++) {
            a += data_ary[i];
            for (int j = 0; j < exp_str_list.length; j++) {
                if (exp_str_list[j].equals(a)) {
                    new_string += exp_str_list[j] + " ";
                    a = "";

                }

            }

        }

        System.out.print(new_string);
    }

    public static void mains(String...strings){
       int arr[] =  {0, -1, 2, -3, 1};
 // -3 -1 0 1 2


        Arrays.sort(arr);
       for(int i=0;i<arr.length-3;i++ ){
        int start = i+1;
        int end = arr.length-1;

        while(start<end){
            if(arr[i]+arr[start]+arr[end]==0) {
                System.out.println(arr[i] + ", " + arr[start] + ", " + arr[end]);
                start++;
            }
            else if(arr[i]+arr[start]+arr[end]<0){
                start++;
            } else {
                end--;
            }
        }

       }
    }


    public static void dutuch(int []a) {
        int i = 0;
        int j= a.length;
        int m =0;

        while (m<j){
            switch (a[m]){
                case 0 :  {
                    // swap(a[i],a[m])
                    i++; m++;
                    break;
                }
                case 1 : {
                   m ++ ;
                   break;
                }
                case 2 : {
                    // swap(a[m],a[j]
                    j--;
                    break;
                }
            }
        }
    }
}
