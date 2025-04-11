class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int maxlen = Math.max(aliceSizes.length , bobSizes.length);
        int alice = 0 , bob = 0;
        for (int i = 0; i < maxlen; i++){
                 if (i < aliceSizes.length)
                     alice += aliceSizes[i];
                 if (i < bobSizes.length)
                    bob += bobSizes[i];
        }
        for (int i = 0; i < aliceSizes.length; i++){
            for (int j = 0; j < bobSizes.length; j++){
                if (aliceSizes[i] == bobSizes[j])
                   continue;
                else {
                    int newAlice = alice - aliceSizes[i];
                    int newBob = bob - bobSizes[j];
                    if ((newAlice + bobSizes[j]) == newBob + aliceSizes[i]){
                        int[] ans = new int[2];
                        ans[0] = aliceSizes[i];
                        ans[1] = bobSizes[j];
                        return ans;
                    }
                }
            }
        }
        return new int[2];
    }
}