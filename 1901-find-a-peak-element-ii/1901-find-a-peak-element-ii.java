class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int r=0;
        int c=0;
        int row=mat.length;
        int col=mat[0].length;

        while(true)
        {
            int x[]={1,-1,0,0};
            int y[]={0,0,-1,1};
            int max=mat[r][c];
            int x2=-1;
            int y2=-1;
            for(int i=0;i<4;i++)
            {
                int x1=x[i]+c;
                int y1=y[i]+r;
                
                if(x1>=0&&x1<col&&y1>=0&&y1<row)
                {
                    if(max<mat[y1][x1])
                    {
                        max=mat[y1][x1];
                        x2=x1;
                        y2=y1;
                    }
                }
            }
            if(x2==-1)
            {
                
                return new int[]{r,c};  
            }
            else
            {
                r=y2;
                c=x2;
            }

        }

    }
}