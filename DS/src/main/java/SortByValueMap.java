import java.util.*;

public class SortByValueMap {
    public static void main(String ...s){

        Map<String,String> map = new HashMap<String,String >();
        map.put("A","Kvalue");
        map.put("D","B");
        map.put("C","A");
        map.put("B","F");
        map.put("K","Mvalues");


        Set<Map.Entry<String,String>> entry = map.entrySet();
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(entry);

        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

       /** for(Map.Entry<String,String> entrys : map.entrySet()){
            System.out.println(entrys.getKey() + " - " + entrys.getValue());
        } */

       for (Map.Entry<String,String> listEntryVal : list){
           System.out.println(listEntryVal.getKey() + " - " + listEntryVal.getValue());
       }
    }


}
