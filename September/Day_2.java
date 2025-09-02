// 3025. Find the Number of Ways to Place People I - Medium

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans  = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(check(points,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean check(int[][] points,int i,int j){
        int[] p1 = points[i];
        int[] p2 = points[j];
        int[] left = new int[2];
        int[] right = new int[2];
        if((p1[0] >= p2[0] && p1[1] <= p2[1])){
            right = p1;
            left = p2;
        } else if (p2[0] >= p1[0] && p2[1] <= p1[1]){
            right = p2;
            left = p1;
        } else {
            return false;
        }

        for(int k=0;k<points.length;k++){
            if(k == i || k == j) continue;
            if(points[k][0] <= right[0] && 
                points[k][0] >= left[0] && 
                points[k][1] <= left[1] && 
                points[k][1] >= right[1]) {
                    return false;
            }
        }
        return true;
    }
}
