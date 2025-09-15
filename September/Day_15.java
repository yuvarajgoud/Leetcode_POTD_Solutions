// 1935. Maximum Number of Words You Can Type - Easy

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        Set<Character> broken = new HashSet<>();

        for(char ch : brokenLetters.toCharArray()){
            broken.add(ch);
        }

        String[] words = text.split(" ");

        int ans = 0;

        for(String word : words){
            boolean canFullyTyped = true;
            for(char ch : word.toCharArray()){
                if(broken.contains(ch)){
                    canFullyTyped = false;
                    break;
                }
            }
            if(canFullyTyped) ans++;
        }

        return ans;
    }
}
