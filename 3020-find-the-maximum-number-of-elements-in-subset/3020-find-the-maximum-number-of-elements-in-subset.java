class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            long key=nums[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        HashSet<Long>set=new HashSet<>();    
        Arrays.sort(nums);
        int ans=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
               count++;
            else
              break;   
        }
        ans=count%2==0?count-1:count;
        set.add(1L);
        for(int i=0;i<n;i++)
        {
            long key=nums[i];  
            if(set.contains(key))
                continue;
            int temp=1;  
            set.add(key);
            while(map.get(key)>=2&&map.containsKey(key*key))
            {
                temp+=2;
                System.out.println(temp);
                key=key*key;
                set.add(key);
            }
            ans=Math.max(ans,temp);  
        }    
        return ans;

        
    }
}