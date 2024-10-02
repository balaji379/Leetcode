class Solution {
    public int[] arrayRankTransform(int[] scores) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ranks = new int[scores.length];
        int rank = 0;
        for( int score : scores )
            ranks[rank++] = score;
        Arrays.sort(ranks);
        rank = 0;
        for( int score : ranks ){
             if( !map.containsKey( score ))
                 map.put( score , ++rank);
        } 
        rank = 0;
        for( var score : scores ){
            ranks[rank] = map.get(score);
            rank += 1;
        }
        return ranks;  
    }

}