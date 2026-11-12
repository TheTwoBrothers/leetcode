class Solution {
    public int countSuffix(int[] nums, int[] target) {
       int dip=0;

       int n=nums.length;
       int arr1[]=nums.clone();
       int arr2[]=target.clone();
      Arrays.sort(arr1);
      Arrays.sort(arr2);

      for(int i=0;i<n;i++)
      {
         if(arr1[i]!=arr2[i])
            return 0;
      }
       for(int i=n-2;i>=0;i--)
       {
            if(target[i+1]>target[i])
            {
                dip=i+1;
                break;
            }
       }
       int ans=0;
       for(int i=0;i<n;i++)
       {
            if(nums[i]!=target[i])
            {
                if(i>=dip)
                {
                    ans+=1;
                    
                }
                break;
            }
            else
            {
                if(i>=dip)
                   ans++;
            }
       }
       return ans;

    }
}