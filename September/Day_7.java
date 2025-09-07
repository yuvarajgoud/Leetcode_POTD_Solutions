// 1304. Find N Unique Integers Sum up to Zero

class Solution {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        int i = 0;
        int j = n-1;
        int k = 1;
        while(i<j){
            nums[i] = -k;
            nums[j] = k;
            k++;
            i++;
            j--;
        }
        if(i==j) nums[i] = 0;
        return nums;
    }
}