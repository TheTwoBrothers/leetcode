class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        char arr[]=new char[n];

        int freq[]=new int [26];

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        int l=0;
        int r=n-1;
        for(int i=0;i<26;i++)
        {
            while(freq[i]>0)
            {
                if(freq[i]%2==1)
                {
                    arr[n/2]=(char)(i+'a');
                    freq[i]--;
                }
                else
                {
                    arr[l]=(char)(i+'a');
                    arr[r]=(char)(i+'a');
                    l++;
                    r--;
                    freq[i]-=2;
                }
            }
        }
        return  new String(arr);
    }
}