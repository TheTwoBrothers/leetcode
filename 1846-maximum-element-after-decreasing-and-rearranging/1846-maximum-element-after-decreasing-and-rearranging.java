class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer>set=new HashSet<>();
        int key=1;
        for(int i=0;i<arr.length;i++)
        {
            if(set.contains(arr[i]))
                 continue;
            if(arr[i]>=key)
            {
                set.add(key);
                key++;
            }     

        }
        return key-1;
    }
}