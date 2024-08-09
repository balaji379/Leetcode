class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

      HashSet<String> set = new HashSet<>();
      HashMap<String,Integer> map = new HashMap<>();
      String lowerp = paragraph.toLowerCase();
      int max = 0;
      for(String str : banned)
          set.add(str.toLowerCase());

      lowerp = lowerp.replaceAll("[!?',;.]"," ");
      String sarr[] = lowerp.split(" ");
      String ans = "";
      for(String str : sarr){
       if (set.contains(str) || str.equals("") || str.equals(" "))
         continue ;
        if(map.containsKey(str)) map.replace(str,(map.get(str)+1));
        else map.put(str,1);
      }
      for(Map.Entry<String,Integer> m : map.entrySet()){
        if(m.getValue()>max) {max=m.getValue(); ans = m.getKey();}
      }

     return ans ;
    }
}