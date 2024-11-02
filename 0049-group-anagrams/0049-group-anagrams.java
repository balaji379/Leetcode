class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> l  =new ArrayList<>();
    HashMap<String,List<String>>  map=new HashMap<>();
    for(String key:strs){
        char[] c=key.toCharArray();
        Arrays.sort(c);
        String val =new String (c);
             if(map.containsKey(val)){
                 map.get(val).add(key);
             }
             else{
                 List<String> ll=new ArrayList<>();
                 ll.add(key);
                 map.put(val,ll);
             }
    }
    for(Map.Entry<String,List<String>> entry:map.entrySet()){
        l.add(entry.getValue());
    }     
    return l;
    }
}
