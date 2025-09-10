// 1733. Minimum Number of People to Teach

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> sadUsers = new HashSet<>();
        for(int j=0;j<friendships.length;j++){
            int u = friendships[j][0] - 1;
            int v = friendships[j][1] - 1;
            Set<Integer> friend1Languages = new HashSet<>();
            for(int lang : languages[u]){
                friend1Languages.add(lang);
            }
            boolean canTalk = false;
            for(int lang : languages[v]){
                if(friend1Languages.contains(lang)){
                    canTalk = true;
                    break;
                }
            }
            if(!canTalk){
                sadUsers.add(u);
                sadUsers.add(v);
            }
        }

        int[] languageKnownUsersCnt = new int[n+1];
        int maxKnownLanguage = 0;

        for(int user : sadUsers){
            for(int lang : languages[user]){
                languageKnownUsersCnt[lang]++;
                maxKnownLanguage = Math.max(maxKnownLanguage,languageKnownUsersCnt[lang]);
            }
        }
        return sadUsers.size() - maxKnownLanguage;
    }
}
