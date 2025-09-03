//3027. Find the Number of Ways to Place People II

import java.util.*;
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        int ans = 0;

        for(int i=0;i<n;i++){
            int lowerYLimit = Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                if(points[j][1] <= points[i][1] && points[j][1] > lowerYLimit){
                    ans++;
                    lowerYLimit = points[j][1];
                    if(lowerYLimit == points[i][1]) break;
                }
            }
        }

        return ans;
    }
}