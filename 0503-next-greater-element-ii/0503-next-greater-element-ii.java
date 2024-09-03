class Solution {
    public int[] nextGreaterElements(int[] nums) {
       Stack<Integer> element = new Stack<>();
        Queue<Integer> max = new LinkedList<>();
        max.add(nums[0]);
        Stack<Integer> index = new Stack<>();
        // store max value from the given nums
        for (int num : nums)
            if (max.peek() < num)
                max.add(num);
        // answer array creation and store -1
        int[] maxElemnt = new int[nums.length];
        for (int i = 0; i < maxElemnt.length; i++)
            maxElemnt[i] = -1;
        // find next max value for each element present in nums
        for (int i = 0; i < nums.length; i++) {
            if (element.isEmpty()) {
                element.push(nums[i]);
                index.push(i);
            } else {
                if (element.peek() >= nums[i]) {

                    element.push(nums[i]);
                    index.push(i);
                } else {
                    while (!element.isEmpty() && element.peek() < nums[i]) {
                        element.pop();
                        int ind = index.pop();
                        // System.out.println("the index to pop :" + ind);
                        maxElemnt[ind] = nums[i];

                    }
                    element.push(nums[i]);
                    index.push(i);
                }
            }
        }
        // System.out.println("the max element is :" + max);
        // System.out.println("the nums :");
        // Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
        // System.out.println();
        // System.out.println("the maxElement element is :");
        // System.out.println();
        // Arrays.stream(maxElemnt).forEach(e -> System.out.print(e + " "));
        // System.out.println("the index  is :" + index);
        while (!max.isEmpty() && !element.isEmpty()) {
            if (max.peek() > element.peek()) {
                element.pop();
                int ind = index.pop();
                maxElemnt[ind] = max.peek();
            } else if (max.peek() <= element.peek())
                max.poll();
        }
        // System.out.println("the maxElement element is :");
        Arrays.stream(maxElemnt).forEach(e -> System.out.print(e + " "));
        return maxElemnt;   
    }
}