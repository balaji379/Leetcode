class Solution {
    public static void addElement(HashMap<String,Integer> map ,String[] s1){
         for(String val : s1)
        {
            if(map.containsKey(val))
               map.replace(val,map.get(val)+1);
            else
              map.put(val,1);
        }
    }
   
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String ,Integer> map =new HashMap<>();
        addElement(map,s1.split(" "));
        addElement(map,s2.split(" "));
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> box : map.entrySet()){
            if(box.getValue()==1)
               list.add(box.getKey());
        }
        String[] output = new String[list.size()];
        for(int i = 0; i<output.length;i++){
            output[i] = list.get(i);
        }
        return output;
    }
}