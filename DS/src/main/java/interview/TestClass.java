package interview;

import java.util.HashMap;
import java.util.Map;

public class TestClass {
    // Duplicate chars from string

    public static void main(String[] args) {
        String s = "programming";
        TestClass testClass = new TestClass();
        testClass.printDuplicateChars(s);
    }

    private void printDuplicateChars(String s){
        Map<Character, Integer> freq = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            if(entry.getValue()>1)
                System.out.println(entry.getKey() + " - " + entry.getValue()) ;
        }
    }

}
