class Solution {
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        int[] perm = new int[n];
        for(int i = 0; i < n; i++){
            perm[i] = i;
        }
        int count = 0, ans = 0;
        while(count != n){
            ans++;
            count = 0;
            for(int i = 0; i < n; i++){
                if(i%2 == 0){
                    arr[i] = perm[i/2];
                    if(arr[i] == i) count++;
                }
                else {
                    arr[i] = perm[n/2 + (i - 1) / 2];
                    if(arr[i] == i) count++;
                }
            }
            for(int i = 0; i < n; i++) perm[i] = arr[i];
            if(count == n) break;
        }
        return ans;
    }
}