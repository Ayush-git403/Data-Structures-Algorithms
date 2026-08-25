class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];
        for (int x : nums) {
            present[x] = true;
        }
        for (int i = 1; ; i++) {
            int x = k * i;
            if (x >= present.length || !present[x]) {
                return x;
            }
        }
    }
}