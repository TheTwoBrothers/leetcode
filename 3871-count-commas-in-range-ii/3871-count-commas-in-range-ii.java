class Solution {
    public long countCommas(long n) {
        return Math.max(0L, n - 999L)
     + Math.max(0L, n - 999999L)
     + Math.max(0L, n - 999999999L)
     + Math.max(0L, n - 999999999999L)
     + Math.max(0L, n - 999999999999999L);
    }
}