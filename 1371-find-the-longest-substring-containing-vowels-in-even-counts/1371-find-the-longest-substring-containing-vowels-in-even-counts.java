class Solution {
    public int findTheLongestSubstring(String s) {
       HashMap<Character,Integer>map=new HashMap<>();
       HashMap<Integer,Integer>state=new HashMap<>();
       state.put(0,-1);
       map.put('a',1);
       map.put('e',2);
       map.put('i',4);
       map.put('o',8);
       map.put('u',16);
       int bits=0;
        int ans=0;
       for(int i=0;i<s.length();i++)
       {
            char ch=s.charAt(i);
            if (map.containsKey(ch))
            {
                bits=bits^map.get(ch);
            }

            if(state.containsKey(bits))
            {
                ans=Math.max(ans,i-state.get(bits));
            }
            else
               state.put(bits,i);

       }

       return ans;

    }
}