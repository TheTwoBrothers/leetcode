class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        boolean find=false;
        HashSet<Integer>set=new HashSet<>();
        set.add(sum);
        for(int i=1;i<nums.length;i++)
        {
             set.add(nums[i]);

             if(!find)
             {
                 if(nums[i-1]+1==nums[i])
                 {
                    sum+=nums[i];
                 }
                 else
                 find=true;
             }
        }
        while(true)
        {
            if(!set.contains(sum))
               return sum;
            else
              sum++;   
        }
    }
}