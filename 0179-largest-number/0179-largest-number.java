class Solution {
    
    public String largestNumber(int[] nums) {
               List<String> list = new ArrayList<>();
               for (int val : nums){
                   list.add(String.valueOf(val));
               }

               Collections.sort(list,new Comparator<>(){
                public int compare(String a,String b){
                    String ab = a + b;
                    String ba = b + a;
                    return ab.compareTo(ba) > 0 ? -1:1;
                }
               });

               String output = "";
               for(String val : list){
                output += val;
               }
               if(output.charAt(0) == '0')
                   return "0";
                return output;
        }
} 