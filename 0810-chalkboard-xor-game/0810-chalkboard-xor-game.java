class Solution {
    public boolean xorGame(int[] nums) {
        int bit=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            bit^=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(bit==0)
           return true;
        boolean ans=false;
        for(int i=0;i<nums.length-1;i++)
        {
            boolean found=false;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if((bit^key)!=0)
                {
                    found=true;
                    value--;
                    ans=!ans;
                    bit=bit^key;
                    if(value==0)
                      map.remove(key);
                    else
                      map.put(key,value);  
                    break;  
                }
            }
            if(!found)
               return ans;
        }
        return ans;   
    }
}