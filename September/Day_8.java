// 1317. Convert Integer to the Sum of Two No-Zero Integers

class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i=1;i<=n;i++){
            if(!containsZero(i) && !containsZero(n-i)){
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        return ans;
    }
    public boolean containsZero(int num){
        while(num > 0){
            int rem = num % 10;
            if(rem  == 0) return true;
            num /= 10;
        }
        return false;
    }
}
