class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i - start) + 1 == 3) {
                if (arr[start] % 2 != 0 && arr[start + 1] % 2 != 0 && arr[start + 2] % 2 != 0)
                    return true;
                start += 1;
            }
        }
        return false;
    }
}