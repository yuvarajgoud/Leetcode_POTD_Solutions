// 2197. Replace Non-Coprime Numbers in Array - Hard ( But Medium Level )

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int curr = nums[i];
            while(!st.isEmpty() && !areCoPrime(st.peek(),curr)){
                curr = lcm(st.pop(),curr);
            }
            st.push(curr);
        }
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
    }

    public boolean areCoPrime(int a , int b){
        return gcd(a , b) == 1;
    }

    public int lcm (int a , int b){
        return (int) ((1L * a * b) / gcd(a,b));
    }

    public int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
