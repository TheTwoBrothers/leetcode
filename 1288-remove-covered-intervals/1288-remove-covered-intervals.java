class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
        if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]); // ascending
       }
        return Integer.compare(b[1], a[1]);     // descending
        });

        int st=intervals[0][0];
        int end=intervals[0][1];
        int ans=1;
        for(int i=1;i<intervals.length;i++)
        {
             if(end>=intervals[i][1])
                continue;
             else
             {
                ans++;
                end=intervals[i][1];
             }
        }
        return ans;
    }
}