class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n=1<<nums.length;
        int max=-1;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            List<Integer>list=new ArrayList<>();
            for(int j=0;j<nums.length;j++)
            {
                if((i&(1<<j))!=0)
                   list.add(nums[j]);
                  
            }
            int or=0;
            for(int j=0;j<list.size();j++)
            {
                or=(or|list.get(j));
            }
            if(or>max)
            {
                ans=1;
                max=or;
            }
            else if(or==max)
            {
                ans++;
            }

        }
        return ans;
    }
}