class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        return findCarr(A,B);
    }
    public  int[] findCarr(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int[] answer = new int[nums1.length];
        int count = 0;

        for (int i = 0; i < nums2.length; i++) {
            map1.put(nums1[i], 1);
            map2.put(nums2[i], 1);

            if (map1.containsKey(nums2[i]) && map2.containsKey(nums1[i])) {
                if (nums1[i] == nums2[i]) {
                    count += 1;
                    answer[i] = count;
                } else {
                    count += 2;
                    answer[i] = count;
                }
            } else if (map1.containsKey(nums2[i])) {
                count += 1;
                answer[i] = count;
            } else if (map2.containsKey(nums1[i])) {
                count += 1;
                answer[i] = count;
            }
            else
              answer[i] = count;
        }
        return answer;
    }
}