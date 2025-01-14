class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        return getCarrUsingStream(A,B);
    }
 public  int[] getCarrUsingStream(int[] a, int[] b) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int[] count = {0};
       return  IntStream.range(0,a.length)
                .map(index ->{
                    map1.put(a[index],1);
                    map2.put(b[index],1);
                    if (map1.containsKey(b[index]) && map2.containsKey(a[index])){
                        if (a[index] == b[index])
                            count[0] += 1;
                        else
                            count[0] += 2;
                        return count[0];
                    } else if (map1.containsKey(b[index])) {
                        count[0] += 1;
                        return count[0];
                    } else if (map2.containsKey(a[index])) {
                        count[0] += 1;
                        return count[0];
                    }
                    return count[0];
                }).toArray();
    }
}