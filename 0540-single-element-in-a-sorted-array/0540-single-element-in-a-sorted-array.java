class Solution {
    public int singleNonDuplicate(int[] nums) {
          int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            else {
                if (nums[mid] == nums[mid + 1])
                    mid += 1;
                if ((right - mid) % 2 != 0) {
                    left = mid + 1;
                } else {
                    if (nums[mid] == nums[mid - 1])
                        mid -= 1;
                    right = mid - 1;
                }
            }

        }

        return nums[right];
    }
}