class Solution {
    public long countCommas(long n) {
        long comma = 0;
        for (long i = 1000; i <= n; i *= 1000) {
            comma += n - i + 1;
        }
        return comma;
    }
}