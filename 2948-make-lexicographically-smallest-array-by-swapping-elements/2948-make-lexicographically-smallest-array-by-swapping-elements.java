class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] arr = nums.clone();
        int n = nums.length;
        Arrays.sort(arr);

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        map1.put(arr[0], arr[0]);
        map.put(arr[0], new PriorityQueue<>());
        map.get(arr[0]).add(arr[0]);

        for (int i = 1; i < n; i++) {
            int group = map1.get(arr[i - 1]);

            if ((arr[i] - arr[i - 1]) <= limit) {
                map1.put(arr[i], group);
                map.get(group).add(arr[i]);
            } else {
                map1.put(arr[i], arr[i]);
                map.put(arr[i], new PriorityQueue<>());
                map.get(arr[i]).add(arr[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            int group = map1.get(nums[i]);
            nums[i] = map.get(group).poll();
        }

        return nums;
    }
}