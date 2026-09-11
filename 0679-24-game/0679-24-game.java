class Solution {
    String s[];
    boolean ans = false;

    double evaluateExpression(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] >= '1' && tokens[i] <= '9') {
                values.push((double) (tokens[i] - '0'));
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    char op = ops.pop();
                    double b = values.pop(), a = values.pop();
                    values.push(op == '+' ? a + b : op == '-' ? a - b : op == '*' ? a * b : a / b);
                }
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && ops.peek() != '(' &&
                        !((tokens[i] == '*' || tokens[i] == '/') && (ops.peek() == '+' || ops.peek() == '-'))) {
                    char op = ops.pop();
                    double b = values.pop(), a = values.pop();
                    values.push(op == '+' ? a + b : op == '-' ? a - b : op == '*' ? a * b : a / b);
                }
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) {
            char op = ops.pop();
            double b = values.pop(), a = values.pop();
            values.push(op == '+' ? a + b : op == '-' ? a - b : op == '*' ? a * b : a / b);
        }
        return values.pop();
    }

    void placing(StringBuilder sb) {
        for (int i = 0; i < 11; i++) {
            if (ans) return;

            int idx = 0;
            StringBuilder exp = new StringBuilder();
            int n = s[i].length();
            
            for (int j = 0; j < n; j++) {
                char ch = s[i].charAt(j);
                if (ch == '0') {
                    exp.append(sb.charAt(idx++));
                } else {
                    exp.append(ch);
                }
            }
            
            double result = evaluateExpression(exp.toString());
            
            if (Math.abs(result - 24.0) < 1e-6) {
                ans = true;
                return;
            }
        }
    }

    void help(StringBuilder sb, int[] freq, int p) {
        if (ans) return;

        if (p == 4) {
            placing(sb);
            return;
        }
        
        for (int i = 1; i <= 9; i++) {
            if (freq[i] != 0) {
                freq[i]--;
                if (p != 3) {
                    sb.append((char) (i + '0')).append('/');
                    help(sb, freq, p + 1);
                    sb.setLength(sb.length() - 2);

                    sb.append((char) (i + '0')).append('*');
                    help(sb, freq, p + 1);
                    sb.setLength(sb.length() - 2);

                    sb.append((char) (i + '0')).append('+');
                    help(sb, freq, p + 1);
                    sb.setLength(sb.length() - 2);

                    sb.append((char) (i + '0')).append('-');
                    help(sb, freq, p + 1);
                    sb.setLength(sb.length() - 2);
                } else {
                    sb.append((char) (i + '0'));
                    help(sb, freq, p + 1);
                    sb.setLength(sb.length() - 1);
                }
                freq[i]++;
            }
        }
    }

    public boolean judgePoint24(int[] cards) {
        ans = false;
        int[] freq = new int[10];
        for (int i : cards) {
            freq[i]++;
        }
        
        s = new String[11];
        s[0] = "((000)00)00";
        s[1] = "(00000)00";
        s[2] = "(000)0000";
        s[3] = "(000)0(000)";
        s[4] = "00(000)00";
        s[5] = "(00(000))00";
        s[6] = "00((000)00)";
        s[7] = "0000(000)";
        s[8] = "00(00(000))";
        s[9] = "00(00000)";
        s[10] = "0000000";

        help(new StringBuilder(), freq, 0);
        return ans;
    }
}