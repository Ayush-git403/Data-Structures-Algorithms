class Solution {
    private int days(int[] wt,int cap){
        int days =1 , loads = 0;
        int n = wt.length;
        for(int i=0;i<n;i++){
      if(loads+wt[i]>cap){
        days++;
        loads = wt[i];
      }else{
        loads += wt[i];
      }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low =0 , high = 0;
        for(int x :weights){
            low = Math.max(low,x);
            high +=x;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            int daysReq = days(weights,mid);
            if(daysReq <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}