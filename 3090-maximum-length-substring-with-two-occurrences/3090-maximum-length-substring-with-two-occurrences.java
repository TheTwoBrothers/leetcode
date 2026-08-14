class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[]=new int[26];
        // Set<Character>set=new HashSet<>();
        // for(char ch:s.toCharArray())
        // {
        //     set.add(ch);
        // }
        int l=0;
        int r=0;
        int ans=0;
        while(r<s.length())
        {
            char ch=s.charAt(r);

            freq[ch-'a']++;
            while(freq[ch-'a']>2)
            {
                char cc=s.charAt(l);
                l++;
                freq[cc-'a']--;
                if(freq[cc-'a']==2)
                {
                    break;
                }
            } 
            ans=Math.max(ans,r-l+1);
            r++;  
        }
        return ans;
    }
}