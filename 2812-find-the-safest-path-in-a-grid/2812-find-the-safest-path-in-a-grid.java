class Solution {
    int arr[][];
    int vis[][];

    class Pair {
        int x;
        int y;
        int dis;

        Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    // BFS to check if path exists with safeness >= val
    boolean check(int val, int n) {

        if (arr[0][0] < val)
            return false;

        vis = new int[n][n];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0, 0));
        vis[0][0] = 1;

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            if (cur.x == n - 1 && cur.y == n - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (vis[nx][ny] == 1)
                    continue;

                if (arr[nx][ny] < val)
                    continue;

                vis[nx][ny] = 1;
                q.add(new Pair(nx, ny, 0));
            }
        }

        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        arr = new int[n][n];
        vis = new int[n][n];

        Queue<Pair> q = new LinkedList<>();

        // Your first BFS (almost unchanged)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid.get(i).get(j) == 1) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            for (int k = 0; k < 4; k++) {

                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (vis[nx][ny] == 1)
                    continue;

                vis[nx][ny] = 1;
                arr[nx][ny] = cur.dis + 1;

                q.add(new Pair(nx, ny, cur.dis + 1));
            }
        }

        int low = 0;
        int high = 2 * n;
        int ans = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (check(mid, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}