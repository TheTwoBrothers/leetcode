class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;

        for(int i:nums1)
            min=Math.min(min,i);

        boolean even=min%2==0;

        for(int i:nums1)
        {
            if(even)
            {
                if(i%2==0)
                   continue;
                if(i-min%2!=0)
                   return false;   
            }
            else
            {
                if(i%2!=0)
                  continue;
                if(i-min%2==0)
                   return false;   
            }
        }  
        return true;  
    }
}