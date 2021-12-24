package Demo;

class ShiftLetters {

    public static void main(String[] args) {
        ShiftLetters solution = new ShiftLetters();
        String s = "bad";
        int[] shifts = {10,20,30};
        System.out.println(solution.shiftingLetters(s,shifts));
    }

    public  String shiftingLetters(String s, int[] shifts) {
        int shiftBy = 0;
        int newVal = 0;
        char[] chArr = s.toCharArray();
        for(int i= shifts.length-1; i>=0; i--) {
            shiftBy += shifts[i];
            newVal = (int)chArr[i]+shiftBy;
            if(newVal > 122){
                newVal = newVal - 122+96;
            }
            chArr[i] = (char) (newVal);
        }
        return String.valueOf(chArr);
    }


}