class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
       Map<String,Integer> map = new HashMap<>();
       List<String> list = new ArrayList<>();
       if (s.length() <= 10)
          return list;
      else{
        int i = 0,limit = 10;
        StringBuilder sb = new StringBuilder();
        while (i < limit){
              sb.append(s.charAt(i++));
        }
        map.put(sb.toString(),1);
        int len = s.length();
        for ( i = 10; i < len; i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String str = sb.toString();
            map.put(str,map.getOrDefault(str,0) + 1);
            if (map.get(str) == 2)
               list.add(str);
        }
       }
       return list;
    }
}