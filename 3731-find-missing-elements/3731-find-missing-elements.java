class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer>ls=new ArrayList<>();
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            for(int j=nums[i-1]+1;j<nums[i];j++)
            {
                ls.add(j);
            }
        }
        return ls;
    }
}