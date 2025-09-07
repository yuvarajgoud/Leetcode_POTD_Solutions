// 3495. Minimum Operations to Make Array Elements Zero

class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            ans += countOperations(l,r);
        }

        return ans;
    }

    private long countOperations(int l,int r){
        long cnt = 0;
        int i = 1;
        while (true) {
            long lower = pow(4, i - 1);
            long upper = pow(4, i) - 1;
            if (lower > r) break;
            long L = Math.max(lower, l);
            long R = Math.min(upper, r);
            if (L <= R) {
                cnt += (R - L + 1) * (long) i;
            }
            i++;
        }
        return (cnt + 1) / 2;
    }

    private long pow(long base, int exp) {
        long result = 1;
        for (int j = 0; j < exp; j++) {
            result *= base;
        }
        return result;
    }
}