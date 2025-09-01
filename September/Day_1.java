// 1792. Maximum Average Pass Ratio - Medium

import java.util.*;
class Solution {
    class Pair{
        double ratio;
        int index;
        public Pair(double r,int i){
            ratio = r;
            index = i;
        }
        public String toString(){
            return "{ r : "+ratio+", i : "+index+" }";
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a,Pair b){
                return Double.compare(b.ratio , a.ratio);
            }
        });

        for(int i=0;i<n;i++){
            int[] a = classes[i];
            double r = ((double)(a[0]+1)/(a[1]+1)) - ((double)a[0]/a[1]) ;
            pq.add(new Pair(r,i));
        }

        while(extraStudents > 0){
            Pair top = pq.poll();
            int i = top.index;
            int pass = ++classes[top.index][0];
            int total = ++classes[top.index][1];
            extraStudents--;
            double r = ((double)(pass+1)/(total+1)) - ((double)pass/total);
            pq.add(new Pair( r , i));
        }
        double ans = 0;
        for(int i=0;i<n;i++){
            int[] a = classes[i];
            ans += ((double)a[0]/a[1]);
        }
        return ans / n;
    }
}