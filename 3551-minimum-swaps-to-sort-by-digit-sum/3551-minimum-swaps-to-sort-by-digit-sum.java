class Solution
{
    int sum(int num)
    {
        int ans = 0;

        while (num != 0)
        {
            ans += num % 10;
            num /= 10;
        }

        return ans;
    }

    public int minSwaps(int[] nums)
    {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++)
        {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) ->
        {
            int s1 = sum(a[0]);
            int s2 = sum(b[0]);

            if (s1 != s2)
            {
                return Integer.compare(s1, s2);
            }

            return Integer.compare(a[0], b[0]);
        });

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            if (vis[i] || arr[i][1] == i)
            {
                continue;
            }

            int j = i;
            int cycle = 0;

            while (!vis[j])
            {
                vis[j] = true;
                j = arr[j][1];
                cycle++;
            }

            ans += cycle - 1;
        }

        return ans;
    }
}