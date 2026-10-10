import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); 
        
        for (int i = 0; i < n; i++) {
            int key = Math.abs(nums1[i] - nums2[i]);
            if (key == 0) continue;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        long sum = (long) k1 + k2;
        
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        list.sort((a, b) -> Integer.compare(b[0], a[0]));
        
        int len = list.size();
        
        for (int i = 0; i < len - 1; i++) { 
            if (sum <= 0) break;
            
            long key = list.get(i)[0];
            long freq = list.get(i)[1];
            long nextkey = list.get(i + 1)[0];
            
            long totalNeeded = (key - nextkey) * freq; 
            
            if (totalNeeded <= sum) {
                sum -= totalNeeded;
                list.get(i + 1)[1] += freq; 
                list.get(i)[1] = 0;         
            } 
            else {
                long reduceBy = sum / freq;
                long remainder = sum % freq;
                
                long newVal = key - reduceBy;
                
                long ans = 0;
                ans += remainder * (newVal - 1) * (newVal - 1); 
                ans += (freq - remainder) * newVal * newVal;    
                
                list.get(i)[1] = 0; 
                sum = 0; 
                
                for (int j = i + 1; j < len; j++) {
                    long remainKey = list.get(j)[0];
                    long remainFreq = list.get(j)[1];
                    ans += remainKey * remainKey * remainFreq;
                }
                return ans;
            }
        }
        
        long ans = 0;
        for (int i = 0; i < len; i++) {
            long key = list.get(i)[0];
            long freq = list.get(i)[1];
            if (freq > 0) {
                ans += key * key * freq;
            }
        }
        
        return ans;
    }
}