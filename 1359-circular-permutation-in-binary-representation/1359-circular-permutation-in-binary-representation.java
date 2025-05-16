class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        return solve(n,start);
    }
     public  List<Integer> solve(int n, int start) {
        List<Integer> grayCode = generateGrayCode(n);
        List<Integer> CirGrayCode = new ArrayList<>();
        int first = -1;
        int len = grayCode.size();

        for (int i = 0; i < len; i++) {
            if (grayCode.get(i) == start || first != -1) {
                if (first == -1)
                    first = i;
                CirGrayCode.add(grayCode.get(i));
            }
        }
        for (int i = 0; i < first; i++) {
            CirGrayCode.add(grayCode.get(i));
        }
        return CirGrayCode;
    }

    public  List<Integer> generateGrayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        list.add(0);
        if (n > 0)
            list.add(1);
        for (int i = 2; i <= n; ++i) {
            cur *= 2;
            for (int j = list.size() - 1; j >= 0; --j) {
                list.add(list.get(j) + cur);
            }
        }
        return list;

    }
}