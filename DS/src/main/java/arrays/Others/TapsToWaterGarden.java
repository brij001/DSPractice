package arrays.Others;

// https://www.youtube.com/watch?v=Pk128gC_sdw
public class TapsToWaterGarden {

    public int minTaps(int n, int[] ranges) {
        int min = 0;
        int max = 0;
        int total =0;

        while(max<n){
            for(int i=0; i<ranges.length; i++){
                int l = i-ranges[i];
                int r = i+ranges[i];

                if(l<=min && r>max){
                    max = r;
                }
            }
            if(min==max) return -1;
            min = max;
            total++;
        }
        return total;
    }
}
