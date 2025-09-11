// 2785. Sort Vowels in a String

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for(char ch : s.toCharArray()){
            if(isVowel(ch)) vowels.add(ch);
        }
        Collections.sort(vowels);
        int i = 0;
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                ch = vowels.get(i++);
            }
            ans.append(ch);
        }
        return ans.toString();
    }

    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
