class Solution
{
    public int minSubarray(int[] nums, int p)
    {
        HashMap<Long, Integer> map = new HashMap<>();

        long sum = 0;
        int n = nums.length;

        for (int x : nums)
        {
            sum += x;
        }

        long mod = sum % p;

        if (mod == 0)
        {
            return 0;
        }

        map.put(0L, -1);

        int ans = n;
        long s = 0;

        for (int i = 0; i < n; i++)
        {
            s += nums[i];

            long key = s % p;
            long target = (key - mod + p) % p;

            if (map.containsKey(target))
            {
                ans = Math.min(ans, i - map.get(target));
            }

            map.put(key, i);
        }

        return ans == n ? -1 : ans;
    }
}