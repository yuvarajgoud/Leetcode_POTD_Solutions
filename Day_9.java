// 2327. Number of People Aware of a Secret

class Solution {

    private static final int MOD = 1000000007;
    
    public class Pair{
        int day;
        int cnt;
        public Pair(int day,int cnt){
            this.day = day;
            this.cnt = cnt;
        }
        public String toString(){
            return "("+day+","+cnt+")";
        }
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Deque<Pair> know = new LinkedList<>();
        Deque<Pair> share = new LinkedList<>();
        know.add(new Pair( 1, 1 ));
        int knowCnt = 1;
        int shareCnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!know.isEmpty() && know.peekFirst().day == i - delay) {
                Pair first = know.pollFirst();
                knowCnt = (knowCnt - first.cnt + MOD) % MOD;
                shareCnt = (shareCnt + first.cnt) % MOD;
                share.add(first);
            }
            if (!share.isEmpty() && share.peekFirst().day == i - forget) {
                Pair first = share.pollFirst();
                shareCnt = (shareCnt - first.cnt + MOD) % MOD;
            }
            if (!share.isEmpty()) {
                knowCnt = (knowCnt + shareCnt) % MOD;
                know.add(new Pair ( i, shareCnt ));
            }
        }
        return (knowCnt + shareCnt) % MOD;
    }
}
