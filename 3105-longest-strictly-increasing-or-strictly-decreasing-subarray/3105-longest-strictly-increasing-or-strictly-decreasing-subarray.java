class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=0;
        int st=0;

        int n=nums.length;
        int i=0;
        for( i=1;i<n;i++)
        {
            if(nums[i-1]>=nums[i])
            {
                ans=Math.max(ans,i-st);
                st=i;
            }
        }
        ans=Math.max(ans,i-st);
        i=0;
        st=0;
        for( i=1;i<n;i++)
        {
            if(nums[i-1]<=nums[i])
            {
                ans=Math.max(ans,i-st);
                st=i;
            }
        }
        ans=Math.max(ans,i-st);
        return ans;
    }
}