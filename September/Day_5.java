// 2749. Minimum Operations to Make the Integer Zero

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=1;i<60;i++){
            long num = num1 - (long) num2 * i;
            if(num < i){
                return -1;
            }
            if( i >= Long.bitCount(num)){
                return i;
            }
        }
        return -1;
    }
}