class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        int l=0;
        int r=0;

        while(r<nums.length)
        {
            int key=nums[r];
            if(!map.containsKey(key))
               map.put(key,0);
            map.put(key,map.get(key)+1);

            while(map.get(key)>k&&l<=r)
            {
                int val=nums[l];
                map.put(val,map.get(val)-1);
                
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;   
        }
        return ans;
    }
}