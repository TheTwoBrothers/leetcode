import java.util.List;

class Solution {
    int MOD = 1000000007;
    // dp[x][y][0] will store the max sum from (x,y) to (0,0)
    // dp[x][y][1] will store the number of ways to get that max sum
    int[][][] dp;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        dp = new int[n][n][2];
        
        // Initialize DP array with -1 to indicate uncalculated states
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
            }
        }

        int[] result = help(board, n - 1, n - 1);
        
        // If the max sum is less than 0, it means the destination is unreachable
        if (result[0] < 0) {
            return new int[]{0, 0};
        }
        
        return result;
    }

    private int[] help(List<String> board, int x, int y) {
        // Base Case 1: Out of bounds
        if (x < 0 || y < 0) return new int[]{-2, 0}; 
        
        char c = board.get(x).charAt(y);
        
        // Base Case 2: Hit an obstacle
        if (c == 'X') return new int[]{-2, 0};

        // Base Case 3: Reached the destination 'E' at (0,0)
        if (x == 0 && y == 0) return new int[]{0, 1};

        // Return memoized result if already calculated
        if (dp[x][y][0] != -1) return dp[x][y];

        // Explore all three valid directions
        int[] up = help(board, x - 1, y);
        int[] left = help(board, x, y - 1);
        int[] diag = help(board, x - 1, y - 1);

        // Find the maximum score among the three paths
        int maxScore = Math.max(up[0], Math.max(left[0], diag[0]));

        // If all paths lead to dead ends, this cell is also a dead end
        if (maxScore == -2) {
            dp[x][y] = new int[]{-2, 0};
            return dp[x][y];
        }

        // Calculate how many ways we can achieve this maxScore
        long ways = 0;
        if (up[0] == maxScore) ways = (ways + up[1]) % MOD;
        if (left[0] == maxScore) ways = (ways + left[1]) % MOD;
        if (diag[0] == maxScore) ways = (ways + diag[1]) % MOD;

        // Calculate current score (don't add values for 'S' or 'E')
        int currentScore = (c == 'S' || c == 'E') ? maxScore : maxScore + (c - '0');

        // Store and return the result
        dp[x][y][0] = currentScore;
        dp[x][y][1] = (int) ways;

        return dp[x][y];
    }
}