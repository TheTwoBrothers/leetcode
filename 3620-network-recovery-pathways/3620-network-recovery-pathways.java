import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int maxEdge = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj.get(u).add(new int[]{v, cost});
            maxEdge = Math.max(maxEdge, cost);
        }
        
        // Binary search for the maximum possible minimum-edge cost
        int low = 0;
        int high = maxEdge;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValid(n, adj, online, k, mid)) {
                ans = mid;      // mid is achievable, record it
                low = mid + 1;  // Try to find an even larger minimum edge
            } else {
                high = mid - 1; // mid is too large, no valid path exists
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int n, List<List<int[]>> adj, boolean[] online, long k, int minAllowedEdge) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        // Priority Queue stores {node, current_total_cost}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long currentCost = curr[1];
            
            // If we reached the end node within the budget, return true
            if (u == n - 1) {
                return currentCost <= k;
            }
            
            // Optimization: ignore outdated longer paths
            if (currentCost > dist[u]) {
                continue;
            }
            
            for (int[] next : adj.get(u)) {
                int v = next[0];
                int edgeCost = next[1];
                
                // Constraints: Node must be online AND edge must meet our minimum requirement
                if (!online[v] || edgeCost < minAllowedEdge) {
                    continue;
                }
                
                if (currentCost + edgeCost < dist[v]) {
                    dist[v] = currentCost + edgeCost;
                    pq.add(new long[]{v, dist[v]});
                }
            }
        }
        
        // If we exhausted the queue and dist[n-1] is still <= k, it's valid
        // (Though we usually catch it inside the while loop)
        return dist[n - 1] <= k;
    }
}