class MyCalendarTwo {
    private Map<Integer,Integer>map ;
    public MyCalendarTwo() {
        this.map  = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        int booked = 0;
        int[] event = {startTime,endTime};
        map.put(event[0], map.getOrDefault(event[0], 0) + 1);
        map.put(event[1], map.getOrDefault(event[1], 0) - 1);
        // System.out.print(map);
        for (int book : map.values()) {
            booked += book;
            if (booked > 2) { // this overlap condition
                map.put(event[0],map.get(event[0]) - 1);
                map.put(event[1],map.get(event[1]) + 1);
                if (map.get(event[0]) == 0)
                     map.remove(event[0]);
                if (map.get(event[1]) == 0)
                     map.remove(event[1]);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */