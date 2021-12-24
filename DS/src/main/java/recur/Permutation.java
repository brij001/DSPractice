package recur;


import java.util.ArrayList;
import java.util.List;

// given string.
public class Permutation {
    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        Permutation permutation = new Permutation();
        //permutation.permute(str, 0, n - 1);
        permutation.printPermutations(str,0, str.length()-1);
        //permutation.printPermutationsUsingVisitedBacktracking(str, new boolean[str.length()], new ArrayList<Character>());
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else { // fixing l
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


    public void printPermutations(String str, int l, int r){
        if(l==r){
            System.out.println(str);
            return;
        }

        for(int i=l; i<str.length(); i++){
            str = swap(str,l,i);
            printPermutations(str, l+1,r);
            str = swap(str,l,i);
        }
    }

    public void printPermutationsUsingVisitedBacktracking(String str, boolean[] visited, List<Character> currList){
        if(currList.size()== str.length()){
            currList.forEach(System.out::print);
            System.out.println("");
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(visited[i])
                continue;

            currList.add(str.charAt(i));
            visited[i]= true;
            printPermutationsUsingVisitedBacktracking(str, visited,currList);
            visited[i] = false;
            currList.remove(currList.size()-1);

        }
    }

}

// This code is contributed by Mihir Joshi
