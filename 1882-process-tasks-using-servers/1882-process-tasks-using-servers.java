class Solution
{
    public int[] assignTasks(int[] servers, int[] tasks)
    {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) ->
        {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) ->
        {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[2], b[2]);
        });

        for (int i = 0; i < servers.length; i++)
        {
            free.add(new int[]{servers[i], i});
        }

        int n = tasks.length;
        int ans[] = new int[n];
        long time = 0;

        for (int i = 0; i < n; i++)
        {
            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time)
            {
                int temp[] = busy.poll();
                free.add(new int[]{temp[1], temp[2]});
            }

            if (free.isEmpty())
            {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time)
                {
                    int temp[] = busy.poll();
                    free.add(new int[]{temp[1], temp[2]});
                }
            }

            int temp[] = free.poll();

            ans[i] = temp[1];

            busy.add(new int[]{
                (int)(time + tasks[i]),
                temp[0],
                temp[1]
            });
        }

        return ans;
    }
}