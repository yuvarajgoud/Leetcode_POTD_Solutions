// 966. Vowel Spellchecker - Medium

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelError = new HashMap<>();
        
        for (String word : wordlist) {
            exactMatch.add(word);
            
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            
            String masked = maskVowels(lower);
            vowelError.putIfAbsent(masked, word);
        }
        
        String[] ans = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            // Exact match
            if (exactMatch.contains(query)) {
                ans[i] = query;
                continue;
            }
            
            // Case insensitive match
            String lower = query.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                ans[i] = caseInsensitive.get(lower);
                continue;
            }
            
            // Vowel error match
            String masked = maskVowels(lower);
            if (vowelError.containsKey(masked)) {
                ans[i] = vowelError.get(masked);
                continue;
            }
            
            // No match
            ans[i] = "";
        }
        
        return ans;
    }
    
    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
