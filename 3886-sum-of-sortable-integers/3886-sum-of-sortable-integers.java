class Solution {
    boolean help(int[] arr, int[] nums, int idx, int k) {
        int drops = 0;
        int dropIndex = -1;
        
        for (int j = 0; j < k - 1; j++) {
            if (arr[idx + j] > arr[idx + j + 1]) {
                drops++;
                dropIndex = j;
            }
        }
        
        if (drops > 1) {
            return false;
        }
        
        int offset = 0;
        if (drops == 1) {
            if (arr[idx + k - 1] > arr[idx]) {
                return false;
            }
            offset = dropIndex + 1;
        }
        
        for (int j = 0; j < k; j++) {
            if (arr[idx + (j + offset) % k] != nums[idx + j]) {
                return false;
            }
        }
        
        return true;
    }

    public int sortableIntegers(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> fact = new ArrayList<>();
        int i = 1;
        
        for (; i * i < n; i++) {
            if (n % i == 0) {
                fact.add(i);
                fact.add(n / i);
            }
        }
        if (i * i == n) {
            fact.add(i);
        }
         
        int ans = 0;
        for (int j = 0; j < fact.size(); j++) {
            int k = fact.get(j);
            boolean check = true;
            
            for (int x = 0; x < n; x += k) {
                check = help(arr, nums, x, k);   
                
                if (!check) {
                   break;
                }
            }
            
            if (check) {
               ans += k;
            }
        } 
        return ans;    
    }
}