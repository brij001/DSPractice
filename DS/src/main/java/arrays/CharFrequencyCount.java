package arrays;

import java.util.HashMap;
import java.util.Map;

public class CharFrequencyCount {

	public static void main(String args[]){
		char[] arr = "a8d2b1c21d1a1d59d1e1c2a45".toCharArray();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Character currChar = arr[0];
		int k = 0;
		for(int i=1;i<arr.length;i++){
			 if(Character.isDigit(arr[i])){
				k = k*10 + arr[i];
			} else{
				if(map.containsKey(currChar)){
					int count = map.get(currChar);
					map.put(currChar, count+k);
				} else{
					map.put(currChar, k);
				}
				currChar = arr[i];
				k = 0;
			}
		}
		
		int max = 0;
		char maxKey = ' ' ;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue()>max){
				max = entry.getValue();
				maxKey = entry.getKey();
			}
		}
		
		System.out.println(maxKey);
	}
}