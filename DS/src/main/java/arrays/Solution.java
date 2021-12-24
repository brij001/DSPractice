package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {


	
	public static void main(String args[]){
		int [][]mat = {{0,0},{1,1},{0,0}};

		Point []points = new Point[mat.length];
		for(int i=0;i<mat.length ; i++) {
			points[i] = new Point(mat[i][0], mat[i][1]);
		}
		//System.out.println(maxPoints(points)); 

		/**
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);l.add(1);l.add(1);	l.add(2);l.add(2);
		System.out.println(majorityElement(l)); */

		int a[] = {-3,-2,0,-1};
		System.out.println(maxSubArray(a));
		
		Stack< Integer> s = new Stack<Integer>();
		
		
	}

	   public static int maxSubArray(int[] nums) {
	        if(nums.length==1)
	            return nums[0];
	        int maxSum=nums[0],currSum = 0;
	        int startIndex=0,endIndex=0,newIndex = 0;
	        
	        for(int i=0;i<nums.length;i++){
	            currSum = currSum + nums[i];
	            
	            if(currSum>maxSum){
	                    maxSum = currSum;
	                    startIndex = newIndex;
	                
	            } if(currSum<=0){
	                currSum = 0;
	                newIndex = i;
	            }
	        }
	        
	        return maxSum;
	    }
	
	

	public static int majorityElement(final List<Integer> A) {

		Map<Integer, Integer> hs = new HashMap<Integer,Integer>();
		int max = 1;
		int maxNum = A.get(0);

		for(Integer i : A){
			if(hs.containsKey(i)){
				int hsVal = hs.get(i)+1;
				if(hsVal>max){
					max=hsVal;
					maxNum = i;
				}
				hs.put(i, hsVal+1);
			} else{
				hs.put(i,1);
			}
		}
		return maxNum;
	}




	public static int maxpt(Point[] points){
		Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
		int result=0;
		for (int i=0;i<points.length;i++){ 
			map.clear();
			int overlap=0,max=0;
			
			for (int j=i+1;j<points.length;j++){
				int x=points[j].x-points[i].x;
				int y=points[j].y-points[i].y;
				if (x==0&&y==0){
					overlap++;
					continue;
				}
				int gcd=getGcd(x,y);
				if (gcd!=0){
					x/=gcd;
					y/=gcd;
				}

				if (map.containsKey(x)){
					if (map.get(x).containsKey(y)){
						map.get(x).put(y, map.get(x).get(y)+1);
					}else{
						map.get(x).put(y, 1);
					}   					
				}else{
					Map<Integer,Integer> m = new HashMap<Integer,Integer>();
					m.put(y, 1);
					map.put(x, m);
				}
				max=Math.max(max, map.get(x).get(y));
			}
			
			result=Math.max(result, max+overlap+1);
		}
		return result;
	}


	public static int maxPoints(Point[] points) {
		HashMap<String, Set<Point>> hash = new HashMap<String, Set<Point>>();
		// Y = mX+c; m = (y1-y2)/(x1-x2), c = y1-mx1
		float c = 0.0f;
		if (points.length == 1)
			return 1;

		int gcd = 1;
		for (int i = 0; i < points.length; i++) {

			for (int j = i + 1; j < points.length; j++) {
				int a = (points[i].x - points[j].x);
				int b = (points[i].y - points[j].y);

				String key = null;
				if (a != 0 && b == 0) {
					key = points[i].y + "y";

				} else if (a == 0 && b != 0) {
					key = points[i].x + "x";
				}  else if (a == 0 && b == 0) {
					key = points[i].x + "x";
				} 

				else {
					gcd = getGcd(Math.abs(a), Math.abs(b));
					if (gcd >= 1) {
						a = a / gcd;
						b = b / gcd;
					}
					c = (float) (points[i].y - b * points[i].x / a);
					key = a + ":" + b + "-" + c;
				}
				if (hash.containsKey(key)) {
					Set<Point> s = hash.get(key);
					s.add(points[i]);
					s.add(points[j]);
					hash.put(key, s);
				} else {
					Set<Point> ss = new HashSet<Point>();
					ss.add(points[i]);
					ss.add(points[j]);
					hash.put(key, ss);
					 Set<Integer> set = new LinkedHashSet<Integer>();
					
				}

			}
		}
		int max = 0;
		for (Map.Entry<String, Set<Point>> entry : hash.entrySet()) {
			if (max < entry.getValue().size())
				max = entry.getValue().size();
		}
		return max;

	}

	public static int getGcd(int n1, int n2) {
		while (n1 != n2) {
			if (n1 > n2)
				n1 -= n2;
			else
				n2 -= n1;
		}
		return n1;
	}
	
	
	


}




class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}