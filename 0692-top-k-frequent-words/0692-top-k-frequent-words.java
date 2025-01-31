class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       Map<String,Integer> map = new HashMap<>();
       PriorityQueue<String> queue = new PriorityQueue( new Comparator<String>(){
              public int compare(String o1,String o2){
                if (map.get(o1) == map.get(o2)){
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
              }
       });
       Set<String> set = new HashSet<>();
       List<String> list = new ArrayList<>();
       for (String word : words){
        map.put(word,map.getOrDefault(word,0) + 1);
       }
       for (String word : words){
        if (!set.contains(word)){
            queue.add(word);
            set.add(word);
        }
       }
    //    System.out.println(map);
     int count = 0;
     while(!queue.isEmpty()){
        if (count < k)
            list.add(queue.poll());
        else break;
        count += 1;
     }
     return list;
    }
}