class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans=Long.MAX_VALUE;
        ans=Math.min(ans,(1L*costBoth)*Math.max(need1,need2));
        ans=Math.min(ans,1L*cost1*need1+1L*cost2*need2);
        long sum=0;
        if(need1>=need2)
        {
            sum+=1L*cost1*(need1-need2);
        }
        else
            sum+=1L*cost2*(need2-need1);
        ans=Math.min(ans,(1L*costBoth)*Math.min(need1,need2)+sum);
        
        
        
        return ans;
    }
}