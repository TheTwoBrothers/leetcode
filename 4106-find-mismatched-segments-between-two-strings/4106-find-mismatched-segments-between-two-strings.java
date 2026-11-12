class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>>ans=new ArrayList<>();
        int st=0;
        int l=0;
        int r=0;

        while(r<s1.length())
        {
            while(r<s1.length()&&s1.charAt(r)!=s2.charAt(r))
            {
                r++;
            }
            if(l!=r)
            {
                List<String>ls=new ArrayList<>();
                ls.add(s1.substring(l,r));
                ls.add(s2.substring(l,r));
                ans.add(ls);
            }
            r++;
            l=r;

        }
        return ans;
    }
}