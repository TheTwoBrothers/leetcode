class Solution {
    public int minimumDeletions(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int ans=n;
        boolean small=false;
        boolean large=false;

        for(int i=0;i<n;i++)
        {
            if(small&&large)
              {
                 ans=Math.min(ans,i);
                 break;
              }
            if(nums[i]==min)
                small=true;
            if(nums[i]==max)
                large=true;          
        }
        small=false;
        large=false;
        for(int i=n-1;i>=0;i--)
        {
            if(small&&large)
              {
                 ans=Math.min(ans,n-i-1);
                 break;
              }
            if(nums[i]==min)
                small=true;
            if(nums[i]==max)
                large=true;          
        }
        small=false;
        large=false;
        int l=0;
        int r=n-1;
       for(int i=0;i<n;i++)
       {
          if(nums[i]==min||nums[i]==max)
          {
             l=i+1;
             break;
          }  
       }
        for(int i=n-1;i>=0;i--)
       {
          if(nums[i]==min||nums[i]==max)
          {
             r=n-i;
             break;
          }  
       }
       ans=Math.min(ans,r+l);
       return ans;
    }
}