class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans=0;
        int sum=0;
        int cur=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);

        for(int num:nums)
        {
            if(num==target)
            {
                cur+=map.getOrDefault(sum,0);
                sum+=1;
            }
            else
            {

                sum-=1;
                cur-=map.getOrDefault(sum,0);
            }
            ans+=cur;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}