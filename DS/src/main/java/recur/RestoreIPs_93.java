package recur;

import java.util.ArrayList;
import java.util.List;

// Input :  s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]
public class RestoreIPs_93 {


    public static void main(String[] args) {
        RestoreIPs_93 restoreIPs_93 = new RestoreIPs_93();
        String s = "25525511135";
        System.out.println(restoreIPs_93.restoreIpAddresses(s));
    }
    List<String> ips = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        ipHelper(s, 0, 0, "");
        return ips;
    }

    private void ipHelper(String orginal, int partition, int i, String ans) {
        if(partition==4 || i == orginal.length()){
            if(partition==4 && i == orginal.length()){
                ips.add(ans.substring(0,ans.length()-1));
            }
            return;
        }


        ipHelper(orginal, partition+1, i+1, ans+ orginal.charAt(i)+"." );
        if(i+2<=orginal.length() && isValid(orginal.substring(i,i+2))  )
            ipHelper(orginal, partition+1, i+2, ans+ orginal.substring(i,i+2)+"." );
        if(i+3<=orginal.length() && isValid(orginal.substring(i,i+3)) )
            ipHelper(orginal, partition+1, i+3, ans+ orginal.substring(i, i+3)+"." );
    }


    private boolean isValid(String str) {
        if(str.charAt(0)=='0')
            return false;
        return Integer.parseInt(str)<=255;
    }
}
