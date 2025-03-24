class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = Math.max(firstCase(arr),secondCase(arr));
        if (max == 0)
           return 1;
        else return max;
    }

    public int firstCase(int... nums) {
        int start = 0, end = 0, len = nums.length, max = 0;
        while (end < len - 1) {
            if ((end + 1) % 2 != 0) {
                if (nums[end] > nums[end + 1]) {
                    max = Math.max(max, ((end + 1) - start) + 1);
                    end += 1;
                } else {
                    end += 1;
                    start = end;
                }
            } else {
                if (nums[end] < nums[end + 1]) {
                    max = Math.max(max, ((end + 1) - start) + 1);
                    end += 1;
                } else {
                    end += 1;
                    start = end;
                }
            }
        }
        return max;
    }

    public int secondCase(int... nums) {
        int start = 0, end = 0, len = nums.length, max = 0;
        while (end < len - 1) {
            if ((end + 1) % 2 == 0) {
                if (nums[end] > nums[end + 1]) {
                    
                    max = Math.max(max, ((end + 1) - start) + 1);
                    end += 1;
                } else {
                    end += 1;
                    start = end;
                }
            } else {
                if (nums[end] < nums[end + 1]) {
                    
                    max = Math.max(max, ((end + 1) - start) + 1);
                    end += 1;
                } else {
                    end += 1;
                    start = end;
                }
            }
        }
        return max;
    }
}