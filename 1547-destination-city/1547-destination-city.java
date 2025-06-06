class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> start = new HashSet<>();
        for (List<String> name : paths){
             start.add(name.get(0));
        }
        for (List<String> name : paths){
            if (!start.contains(name.get(1)))
               return name.get(1);
        }
        return "";
    }
}