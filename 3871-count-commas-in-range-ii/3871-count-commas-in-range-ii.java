class Solution {

    long max(long a, long b) {
        return a > b ? a : b;
    }

    public long countCommas(long n) {
        return max(0L, n - 999L)
             + max(0L, n - 999999L)
             + max(0L, n - 999999999L)
             + max(0L, n - 999999999999L)
             + max(0L,n-999999999999999L);
    }
}