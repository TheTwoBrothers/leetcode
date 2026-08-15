class Solution {
    PriorityQueue<Integer> pq;
    HashMap<Integer, PriorityQueue<Integer>> map;

    public int[] maxSlidingWindow(int[] nums, int k) {
        map = new HashMap<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = nums.length;
        if (n == 0) return new int[0];

        for (int i = 0; i < k; i++) {
            int key = nums[i];

            if (!map.containsKey(key))
                map.put(key, new PriorityQueue<>(Collections.reverseOrder()));

            map.get(key).add(i);
            pq.add(key);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek();

        int ct = 1;

        for (int i = k; i < n; i++) {
            int key = nums[i];

            if (!map.containsKey(key))
                map.put(key, new PriorityQueue<>(Collections.reverseOrder()));

            map.get(key).add(i);
            pq.add(key);

            while (!pq.isEmpty()) {
                int max = pq.peek();

                if (!map.containsKey(max)) {
                    pq.poll();
                    continue; 
                }

                int idx = map.get(max).peek();

                if (idx <= i - k) {
                    map.remove(max);
                    pq.poll();
                } else {
                    break;
                }
            }

            ans[ct++] = pq.peek();
        }

        return ans;
    }
}