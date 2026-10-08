class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;;
        int ans=0;
        map.put(0,-1);
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
               sum--;
            else
                sum++;
               
            int key=sum;

            if(map.containsKey(key))
            {
                ans=Math.max(ans,i-map.get(key));
            }
            else
            {
                map.put(key,i);
            }


                
        }
        return ans;
    }
}