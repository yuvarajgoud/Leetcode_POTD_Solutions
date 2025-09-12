// 3227. Vowels Game in a String

class Solution {
    public boolean doesAliceWin(String s) {
        int vowelsCnt = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)) vowelsCnt++;
        }
        return vowelsCnt == 0 ? false : true;
    }
    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
