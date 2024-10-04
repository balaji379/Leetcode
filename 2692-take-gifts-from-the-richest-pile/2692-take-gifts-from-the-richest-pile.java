class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>((a,b)->Long.compare(b, a));
        for( int girft : gifts )  
           queue.add( Long.valueOf( girft ));
        while( k >0 ){
             Long pile = queue.poll();
             pile =  (long)Math.floor(Math.sqrt(pile)) ;
             queue.add(pile);
             k -= 1;
        }
        Long total_number_girft = Long.valueOf(0);
        for( Long girft : queue)
           total_number_girft += girft; 
        return total_number_girft;
    }
}