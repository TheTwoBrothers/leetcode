class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }


        int currentRow=0;
        boolean goingDown=false;

        for(char ch:chars){
            rows[currentRow].append(ch);

            if(currentRow == 0 || currentRow==numRows-1){
                goingDown=!goingDown;
            }

            if(goingDown){
                currentRow++;
            }else{
                currentRow--;
            }


        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb:rows){
            result.append(sb);
        }

        return result.toString();
        
    }
}