package recur;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

/**
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
  */
public class LetterCombination {

    public static void main(String args[]){

        String keyDigits = "345";
        String[] mappings = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqr"
        };

        List<String> result = new ArrayList<String>();
        getLetterCombination(keyDigits, mappings, result, 0, "");

        result.forEach(System.out :: println);

    }


    public static void getLetterCombination(String keyDigits, String[] mappings, List<String> result, int index, String current){
        if(index==keyDigits.length()) {
            result.add(current);
            return ;
        }

        String mapping = mappings[keyDigits.charAt(index)-'0'];
        for(int i=0; i<mapping.length(); i++){
             getLetterCombination(keyDigits,mappings,result, index+1,current+mapping.charAt(i));
        }

    }


}
