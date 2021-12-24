package arrays;

// Recursively remove all adjacent duplicates
// Given a string, recursively remove adjacent duplicate characters from the string. The output string should not have any adjacent duplicates. See following examples.
public class abc {

	static String removeUtil(String str, char last_removed) 
	{ 
			// If length of string is 1 or 0 
			if (str.length() == 0 || str.length() == 1) 
				return str; 

			// Remove leftmost same characters and recur for remaining 
			// string 
			if (str.charAt(0) == str.charAt(1)) 
			{ 
				last_removed = str.charAt(0); 
				while (str.length() > 1 && str.charAt(0) == str.charAt(1)) 
					str = str.substring(1, str.length()); 
				str = str.substring(1, str.length()); 
				return removeUtil(str, last_removed); 
			} 

			// At this point, the first character is definitely different 
			// from its adjacent. Ignore first character and recursively 
			// remove characters from remaining string 
			String rem_str = removeUtil(str.substring(1,str.length()), last_removed); 

			// Check if the first character of the rem_string matches with 
			// the first character of the original string 
			if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0)) 
			{ 
				last_removed = str.charAt(0); 
				return rem_str.substring(1,rem_str.length()); // Remove first character 
			} 


			// If remaining string becomes empty and last removed character 
			// is same as first character of original string. This is needed 
			// for a string like "acbbcddc" 
			if (rem_str.length() == 0 && last_removed == str.charAt(0)) 
				return rem_str; 

			// If the two first characters of str and rem_str don't match, 
			// append first character of str before the first character of 
			// rem_str 
			return (str.charAt(0) + rem_str); 
	} 

	static String remove(String str) 
	{ 
			char last_removed = '\0'; 
			return removeUtil(str, last_removed);	 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
			String str1 = "acbbcddc"; 
			System.out.println(remove(str1)); 

			String str2 = "azxxxzy"; 
			System.out.println(remove(str2)); 

			String str3 = "caaabbbaac"; 
			System.out.println(remove(str3)); 
	}

    public static class SetZeroMatrix {

        public static void main(String ...s){
            int [][]matrix = {
                    {0,1,2,0},
                    {3,4,5,2},
                    {1,3,1,5}
            }; // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
            setZeroes(matrix);
        }
        public static void setZeroes(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            boolean col0 = false;
            boolean row0 = false;
            int col0_act = matrix[0][0];

            System.out.println("Before ...");
            printMatrix(matrix);

            for(int i=0; i<rows; i++) {
                for(int j=0; j<cols; j++){
                    if(matrix[i][j] == 0 && i==0){
                        row0 = true;
                    } if(matrix[i][j] == 0 && j==0){
                        col0 = true;
                    }
                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            System.out.println("Marked");
            printMatrix(matrix);

            for( int i=rows-1;i>=0;i--){
                for(int  j=cols-1; j>=0; j--){
                    if( ( i!=0 && j!=0) && (matrix[i][0] == 0 || matrix[0][j]==0)){
                        // (i!=0 )
                        matrix[i][j] = 0;
                    } else if( (j==0 && col0 ) || (i==0 && row0 )){
                        matrix[i][j] = 0;
                    }
                }
            }
            System.out.println("After ...");
            printMatrix(matrix);

        }


        public static void printMatrix(int [][]matrix ){
            int rows = matrix.length;
            int cols = matrix[0].length;
            for(int i=0; i<rows; i++) {
                for(int j=0; j<cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}

