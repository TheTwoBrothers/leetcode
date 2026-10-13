class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
       for(int i=0;i<n;i++)
       {
            nums[i]=Math.abs(nums[i]);
       }
       Arrays.sort(nums);

       long ans=0;
       int l=0;
       int r=n-1;
       while(l<r)
       {
            ans+=1L*nums[r]*nums[r];
            ans-=1L*nums[l]*nums[l];
            l++;
            r--;
       }
       if(l==r)
          ans+=1L*nums[r]*nums[r];
        return ans;   
    }
}