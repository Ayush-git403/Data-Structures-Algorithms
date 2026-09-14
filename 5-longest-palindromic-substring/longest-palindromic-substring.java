class Solution {
    private int expand(String s , int l , int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int l=0 ,r =0;
        for(int i=0;i<n;i++){
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);
            int len = Math.max(odd,even);
            if(len > (r-l+1)){
                l = i-(len-1)/2;
                r = i+len/2;
            }
        }
       return s.substring(l,r+1);
    }
}