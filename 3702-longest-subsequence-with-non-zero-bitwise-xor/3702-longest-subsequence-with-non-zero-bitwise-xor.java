class Solution {
    public int longestSubsequence(int[] nums) {
       int n=nums.length;
       int xor=0;
       int ans=0;
        int ctZero=0;
       for(int i=0;i<n;i++)
       {
           if(nums[i]==0)
           {
              ctZero++;
             continue;
           }
           xor^=nums[i];
           ans++;  
              
            
       }
      return ans==0?0:(xor==0?ans+ctZero-1:ans+ctZero);   
    }
}