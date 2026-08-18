class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
       int num[]=new int [51];
        Arrays.fill(num,-1);
       for(int i=0;i<=n-k;i++)
       {
         for(int j=i;j<i+k;j++)
         {
            
             if(num[nums[j]]==-1)
            {  
                num[nums[j]]=i;  
            }
            else if(num[nums[j]]!=i)
            {
                num[nums[j]]=-2;
            }

         }
       }
      
       for(int i=50;i>=0;i--)
       {
            if(num[i]!=-1&&num[i]!=-2)
              return i;
       }
        return -1;
    }
}