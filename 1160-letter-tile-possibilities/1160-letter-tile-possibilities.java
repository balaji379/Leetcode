class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> checker = new HashSet<>();
        return findPossibities("",tiles,new ArrayList<>(),checker,0);
//        System.out.println(checker);
    }
    public static int findPossibities(String p,String up, List<String> list, Set<String> checker,int count){
        
        if(checker.contains(p))
            return count;

        if (!p.isEmpty() && !checker.contains(p)){
            count += 1;
            checker.add(p);
        }

        if (up.isEmpty()){
            return count;
        }

        int length = up.length(),len = p.length();
//        StringBuilder sp = new StringBuilder(p);
        StringBuilder sb = new StringBuilder(up);
        for (int i = 0; i < length; i++){
            char c = up.charAt(i);
            sb.deleteCharAt(i);
            StringBuilder temp = new StringBuilder(p);
            for (int j = 0; j < len + 1; j++){
                   temp.insert(j,c);
                   count = findPossibities(temp.toString(),sb.toString(),list,checker,count);
                   temp.deleteCharAt(j);
            }
            sb.insert(i,c);
        }
        return count;
    }
}