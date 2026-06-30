class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int l = 0;
        
        for(int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size() == 3) {
                ans += (n - r);

                char c = s.charAt(l);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
                l++;
            }
        }
        return ans;
    }
}