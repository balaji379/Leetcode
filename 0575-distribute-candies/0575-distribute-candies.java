class Solution {
    public int distributeCandies(int[] candyType) {

          HashSet<Integer> type = new HashSet<>();
          for(int v : candyType)       type.add(v);
          int eatablecandy =  candyType.length/2,totalType = type.size();
          return eatablecandy<totalType ?eatablecandy:totalType;

    }
}