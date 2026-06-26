class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
         int n= nums.length;
         int result=0;
        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                int l=j+1;
                int r=n-1;
                for(int k=j+1;k<n;k++)
                 {
                   int sum=nums[i]+nums[j]+nums[k];
                   if(ans>Math.abs(target-sum))
                   {
                      ans=Math.abs(target-sum);
                      result=sum;
                   }
                    
                 }

                
                
            }
        }
        // System.out.println(ans+"---"+target);
        return result;
    }
}