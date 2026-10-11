class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        long w=0;
        for(int i=0;i<n;i++)
        {
            arr[i][0]=nums[i];
            arr[i][1]=cost[i];
            w+=cost[i];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        long pre=0;
        int x=-1;
        for(int i=0;i<n;i++)
        {
            pre+=arr[i][1];
            if(pre>=(w+1)/2)
            {
                x=arr[i][0];
                break;
            }
        }
        long ans=0;

        for(int i=0;i<n;i++)
        {
            ans += 1L * Math.abs(nums[i] - x) * cost[i];
        }
        return ans;
    }
}