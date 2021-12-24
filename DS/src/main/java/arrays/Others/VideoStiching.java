package arrays.Others;

// https://www.youtube.com/watch?v=Gg64QXc9K0s&feature=youtu.be
// https://github.com/prakashshuklahub/Interview-Questions
// https://github.com/prakashshuklahub/Interview-Questions/commit/94b678596f558be6e700b4f4777fe9e02a9c4bac

public class VideoStiching {

    // [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
    // Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T])
    public int videoStitching(int[][] clips, int T) {

        int min = 0;
        int max = 0;
        int total =0;


        while(max<T){

            for(int i=0;i<clips.length;i++){
                int l = clips[i][0];
                int r = clips[i][1];
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
