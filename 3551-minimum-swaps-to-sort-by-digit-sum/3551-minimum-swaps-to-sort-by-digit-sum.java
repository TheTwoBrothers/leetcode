class Solution {
    int sum(int num)
    {
        int sum=0;
        while(num!=0)
        {
            int r=num%10;
            sum+=r;
            num/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        HashMap<Integer,Integer>idxMap=new HashMap<>();
        HashMap<Integer,Integer>valMap=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            valMap.put(nums[i],i);
            idxMap.put(i,nums[i]);
        }

        TreeMap<Integer,TreeSet<Integer>>map=new TreeMap<>();

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) ->
        {
            int s1 = sum(a);
            int s2 = sum(b);

            if (s1 != s2)
            {
                return Integer.compare(s1, s2);
            }

            return Integer.compare(a, b);
        });

        Arrays.sort(arr, (a, b) ->
        {
            int s1 = sum(a);
            int s2 = sum(b);

            if (s1 != s2)
            {
                return Integer.compare(s1, s2);
            }

            return Integer.compare(a, b);
        });

         int ans=0;
        // for(int i=0;i<n;i++)
        //    IO.print(arr[i]+"  ");
         for(int i=0;i<n;i++)
         {
            if(valMap.get(arr[i])!=i)
            {
                ans++;
                int id=valMap.get(arr[i]);
                valMap.put(arr[i],i);
                int num=idxMap.get(i);
                idxMap.put(i,arr[i]);
                valMap.put(num,id);
                idxMap.put(id,num);

                // IO.println(id+" -- "+num);

            }
         }

        return  ans;




    }
}