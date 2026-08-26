class Solution {
    // int score(String s)
    // {

    // }
    public String shortestBeautifulSubstring(String s, int k) {
        int len = 1000;

        int n = s.length();

        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '0')
                continue;
            int ct = 0;
            for (int j = i; j < n; j++) {
                char ch1 = s.charAt(j);

                if (ch1 == '1')
                    ct++;
                if (ct == k) {
                    if (len > (j - i + 1)) {
                        set =   new TreeSet<>();
                        set.add(s.substring(i, j + 1));
                        len=j - i + 1;

                    } else if (len == (j - i + 1)) {
                        set.add(s.substring(i, j + 1));
                    }
                }
            }
        }
         
        for (String x : set) {
            return x;
        }
        return "";

    }
}