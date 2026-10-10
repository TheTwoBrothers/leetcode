class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);

        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            int key=sum%k;

            if(map.containsKey(key))
            {
                if(i-map.get(key)>=2)
                   return true;
            }
            else
             map.put(key,i);
        }
        return false;
    }
}