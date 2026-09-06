class Solution {
     static int[][] dp;
    static int solve(String X,String Y,int n , int m){
        if(m==0) return 1;
        if(n==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(X.charAt(n-1)==Y.charAt(m-1)){
         dp[n][m] = solve(X,Y,n-1,m-1)+solve(X,Y,n-1,m);
        }else {
    dp[n][m] = solve(X,Y,n-1,m);
}
        return dp[n][m] ;
    }
    public int numDistinct(String s, String t) {
    int n =s.length();
    int m = t.length();
    dp= new int[n+1][m+1];
     for(int[] row :dp){
        Arrays.fill(row,-1);
       }
    return solve(s,t,n,m);
    }
}